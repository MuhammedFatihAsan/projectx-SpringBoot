package projectx.northwind.business.abstracts;

import projectx.northwind.core.exceptions.types.article.ArticleNotFoundException;
import projectx.northwind.core.exceptions.types.comment.CommentAlreadyExistsInThisArticleThisUserException;
import projectx.northwind.core.exceptions.types.comment.CommentNotFoundException;
import projectx.northwind.core.exceptions.types.comment.NoCommentsExistsException;
import projectx.northwind.core.exceptions.types.common.EmptyListException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.dtos.requests.CreateCommentRequestDto;
import projectx.northwind.entities.dtos.requests.UpdateCommentRequestDto;
import projectx.northwind.entities.dtos.responses.CommentListByArticleDto;
import projectx.northwind.entities.dtos.responses.CommentListByUserDto;
import projectx.northwind.entities.dtos.responses.CommentResponseDto;

import java.util.List;

public interface CommentService {

    // =================== INTERNAL METHODS ===================

    boolean existsByBody(String body);

    boolean existsBy();

    boolean existsById(int commentId);

    // =================== RESPONSE METHODS ===================

    DataResult<List<CommentResponseDto>> getAll() throws NoCommentsExistsException;

    DataResult<CommentListByUserDto> getAllByCommentUser_Id(Integer userId) throws UserNotFoundException, EmptyListException;

    DataResult<CommentListByArticleDto> getAllByCommentArticle_Id(Integer articleId) throws ArticleNotFoundException, EmptyListException;

    // =================== REQUEST METHODS ===================

    Result add(CreateCommentRequestDto newComment) throws UserNotFoundException, ArticleNotFoundException, CommentAlreadyExistsInThisArticleThisUserException;

    Result updateComment(UpdateCommentRequestDto updateCommentRequestDto) throws CommentNotFoundException, CommentAlreadyExistsInThisArticleThisUserException;

}
