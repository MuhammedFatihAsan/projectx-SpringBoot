package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.ArticleService;
import projectx.northwind.business.abstracts.CommentService;
import projectx.northwind.business.abstracts.UserService;
import projectx.northwind.core.exceptions.types.article.ArticleNotFoundException;
import projectx.northwind.core.exceptions.types.comment.CommentAlreadyExistsInThisArticleThisUserException;
import projectx.northwind.core.exceptions.types.comment.NoCommentsExistsException;
import projectx.northwind.core.exceptions.types.common.EmptyListException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.mapping.CommentMapper;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.core.utilities.results.SuccessDataResult;
import projectx.northwind.core.utilities.results.SuccessResult;
import projectx.northwind.dataAccess.abstracts.CommentDao;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.concretes.Comment;
import projectx.northwind.entities.dtos.requests.CreateCommentRequestDto;
import projectx.northwind.entities.dtos.responses.CommentListByArticleDto;
import projectx.northwind.entities.dtos.responses.CommentListByUserDto;
import projectx.northwind.entities.dtos.responses.CommentResponseDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentManager implements CommentService {

    private final CommentDao commentDao;
    private final UserService userService;
    private final ArticleService articleService;

    @Autowired
    public CommentManager(CommentDao commentDao,  UserService userService,  ArticleService articleService) {

        this.commentDao = commentDao;
        this.userService = userService;
        this.articleService = articleService;
    }

    // =================== INTERNAL METHODS ===================

    @Override
    public boolean existsByBody(String body) {

        return this.commentDao.existsByBody(body);
    }

    @Override
    public boolean existsBy() {

        return this.commentDao.existsBy();
    }

    // =================== RESPONSE METHODS ===================

    @Override
    public DataResult<List<CommentResponseDto>> getAll() throws NoCommentsExistsException {

        checkAnyCommentExists();

        List<Comment> comments = this.commentDao.findAll();

        List<CommentResponseDto> responseDtoList = new ArrayList<>();

        for (Comment comment : comments) {

            responseDtoList.add(CommentMapper.mapCommentResponseDto(comment));
        }

        return new SuccessDataResult<List<CommentResponseDto>>(responseDtoList);
    }

    @Override
    public DataResult<CommentListByUserDto> getAllByCommentUser_Id(Integer userId) throws UserNotFoundException, EmptyListException {

        checkUserExistsById(userId);

        String userName = this.userService.findById(userId).getName();

        List<Comment> comments = this.commentDao.getAllByCommentUser_Id(userId);

        checkListIsEmpty(comments, this.userService.findById(userId).getName());

        return new SuccessDataResult<CommentListByUserDto>(CommentMapper.mapCommentListByUserDto(comments, userName));
    }

    @Override
    public DataResult<CommentListByArticleDto> getAllByCommentArticle_Id(Integer articleId) throws ArticleNotFoundException, EmptyListException {

        checkArticleExistsById(articleId);

        String articleTitle = this.articleService.findById(articleId).getTitle();

        List<Comment> comments = this.commentDao.getAllByCommentArticle_Id(articleId);

        checkListIsEmpty(comments, articleTitle);

        return new SuccessDataResult<CommentListByArticleDto>(CommentMapper.mapCommentListByArticleDto(comments, articleTitle));
    }

    // =================== REQUEST METHODS ===================

    @Override
    public Result add(CreateCommentRequestDto newComment) throws UserNotFoundException, ArticleNotFoundException, CommentAlreadyExistsInThisArticleThisUserException {

        checkUserExistsById(newComment.getUserId());
        checkArticleExistsById(newComment.getArticleId());
        checkAlreadyExistsInThisArticle(newComment.getCommentBody(), newComment.getUserId(), newComment.getArticleId());

        Comment comment = new Comment();

        comment.setBody(newComment.getCommentBody());
        comment.setCommentUser(this.userService.findById(newComment.getUserId()));
        comment.setCommentArticle(this.articleService.findById(newComment.getArticleId()));

        this.commentDao.save(comment);

        return new SuccessResult("Comment added!");
    }

    // =================== BUSINESS RULE CHECKS ===================

    private void checkAnyCommentExists() throws NoCommentsExistsException {

        if(!existsBy()){

            throw new NoCommentsExistsException("No comment are registered!");
        }
    }

    private void checkUserExistsById(int userId) throws UserNotFoundException {

        if(!this.userService.existsById(userId)){

            throw new UserNotFoundException(userId + " : that id not found in users!");
        }
    }

    private void checkListIsEmpty(List<Comment> comments, String message) throws EmptyListException {

        if(comments.isEmpty()){

            throw new EmptyListException("Comment list is empty for : " + message);
        }
    }

    private void checkArticleExistsById(int articleId) throws ArticleNotFoundException {

        if(!this.articleService.existsById(articleId)){

            throw new ArticleNotFoundException(articleId + " : that article id not found!");
        }
    }

    private void checkAlreadyExistsInThisArticle(String commentBody, int userId, int articleId) throws CommentAlreadyExistsInThisArticleThisUserException {

        Article article = this.articleService.findById(articleId);

        List<Comment> comments = article.getComments();

        for(Comment comment : comments){

            if(comment.getBody().equals(commentBody) && comment.getCommentUser().getId() == userId){

                throw new CommentAlreadyExistsInThisArticleThisUserException("The comment was made by the same user on the same article!");
            }
        }
    }

}
