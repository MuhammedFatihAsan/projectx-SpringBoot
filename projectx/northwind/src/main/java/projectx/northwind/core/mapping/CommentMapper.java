package projectx.northwind.core.mapping;

import projectx.northwind.entities.concretes.Comment;
import projectx.northwind.entities.dtos.responses.CommentListByArticleDto;
import projectx.northwind.entities.dtos.responses.CommentListByUserDto;
import projectx.northwind.entities.dtos.responses.CommentResponseDto;

import java.util.ArrayList;
import java.util.List;

public class CommentMapper {

    public static CommentResponseDto mapCommentResponseDto(Comment comment) {

        CommentResponseDto dto = new CommentResponseDto();

        dto.setCommentId(comment.getId());
        dto.setCommentBody(comment.getBody());
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

    public static CommentListByArticleDto mapCommentListByArticleDto(List<Comment> comments, String articleTitle) {

        CommentListByArticleDto dto = new CommentListByArticleDto();

        List<CommentResponseDto> commentResponseDtos = new ArrayList<>();

        for (Comment comment : comments) {

            commentResponseDtos.add(mapCommentResponseDto(comment));
        }

        dto.setArticleTitle(articleTitle);
        dto.setCommentsDto(commentResponseDtos);

        return dto;
    }

}
