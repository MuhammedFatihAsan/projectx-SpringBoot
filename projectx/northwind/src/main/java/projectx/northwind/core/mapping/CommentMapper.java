package projectx.northwind.core.mapping;

import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.concretes.Comment;
import projectx.northwind.entities.dtos.responses.CommentListByUserDto;
import projectx.northwind.entities.dtos.responses.CommentResponseDto;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CommentMapper {

    public static CommentResponseDto mapCommentResponseDto(Comment comment) {

        CommentResponseDto dto = new CommentResponseDto();

        dto.setId(comment.getId());
        dto.setBody(comment.getBody());
        dto.setArticleTitle(comment.getCommentArticle().getTitle());
        dto.setUserName(comment.getCommentUser().getName());

        return dto;
    }

    public static CommentListByUserDto mapCommentListByUserDto(List<Comment> comments, String userName) {

        CommentListByUserDto dto = new CommentListByUserDto();

        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();
        for (Comment comment : comments) {

            commentResponseDtos.add(mapCommentResponseDto(comment));
        }

        dto.setUserName(userName);
        dto.setCommentsDto(commentResponseDtos);

        return dto;
    }

}
