package projectx.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectx.northwind.business.abstracts.CommentService;
import projectx.northwind.core.exceptions.types.comment.NoCommentsExistsException;
import projectx.northwind.core.exceptions.types.common.EmptyListException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.entities.dtos.responses.CommentListByUserDto;
import projectx.northwind.entities.dtos.responses.CommentResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/comments")
public class CommentsController {

    private final CommentService commentService;

    @Autowired
    public CommentsController(CommentService commentService) {

        this.commentService = commentService;
    }

    // =================== RESPONSE METHODS ===================

    @GetMapping("/getAll")
    public DataResult<List<CommentResponseDto>> getAll() throws NoCommentsExistsException {

        return this.commentService.getAll();
    }

    @GetMapping("/getAllByCommentUser_Id")
    public DataResult<CommentListByUserDto> getAllByCommentUser_Id(Integer userId) throws UserNotFoundException, EmptyListException {

        return this.commentService.getAllByCommentUser_Id(userId);
    }

}
