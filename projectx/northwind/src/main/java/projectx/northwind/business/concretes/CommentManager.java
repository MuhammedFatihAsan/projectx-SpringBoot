package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.CommentService;
import projectx.northwind.business.abstracts.UserService;
import projectx.northwind.core.exceptions.types.comment.NoCommentsExistsException;
import projectx.northwind.core.exceptions.types.common.EmptyListException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.mapping.CommentMapper;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.SuccessDataResult;
import projectx.northwind.dataAccess.abstracts.CommentDao;
import projectx.northwind.entities.concretes.Comment;
import projectx.northwind.entities.dtos.responses.CommentListByUserDto;
import projectx.northwind.entities.dtos.responses.CommentResponseDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentManager implements CommentService {

    private final CommentDao commentDao;
    private final UserService userService;

    @Autowired
    public CommentManager(CommentDao commentDao,  UserService userService) {

        this.commentDao = commentDao;
        this.userService = userService;
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

        checkListIsEmpty(comments, userName);

        return new SuccessDataResult<CommentListByUserDto>(CommentMapper.mapCommentListByUserDto(comments, userName));
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

    private void checkListIsEmpty(List<Comment> comments, String userName) throws EmptyListException {

        if(comments.isEmpty()){

            throw new EmptyListException("Comment list is empty for userName: " + userName);
        }
    }

}
