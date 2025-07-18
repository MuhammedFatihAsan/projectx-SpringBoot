package projectx.northwind.business.abstracts;

import projectx.northwind.core.exceptions.types.comment.NoCommentsExistsException;
import projectx.northwind.core.exceptions.types.common.EmptyListException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.entities.dtos.responses.CommentListByUserDto;
import projectx.northwind.entities.dtos.responses.CommentResponseDto;

import java.util.List;

public interface CommentService {

    // =================== INTERNAL METHODS ===================

    boolean existsByBody(String body);

    boolean existsBy();

    // =================== RESPONSE METHODS ===================

    DataResult<List<CommentResponseDto>> getAll() throws NoCommentsExistsException;

    DataResult<CommentListByUserDto> getAllByCommentUser_Id(Integer userId) throws UserNotFoundException, EmptyListException;

}
