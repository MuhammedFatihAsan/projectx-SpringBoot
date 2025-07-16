package projectx.northwind.core.mapping;

import projectx.northwind.core.entities.User;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.concretes.Comment;
import projectx.northwind.entities.dtos.responses.UserResponseDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class UserMapper {

    public static List<String> extractArticleTitlesWritten(User user) {

        if (user.getArticles() == null) {
            return Collections.emptyList();
        }

        return user.getArticles().stream()
                .map(Article::getTitle)
                .collect(Collectors.toList());
    }

    public static List<String> extractCommentsWritten(User user) {

        if (user.getComments() == null) {
            return Collections.emptyList();
        }

        return user.getComments().stream()
                .map(Comment::getBody) // Direkt methoda referans verebiliyorum, ::
                .collect(Collectors.toList());
    }

    public static List<String> extractLikedArticleTitles(User user) {

        if (user.getLikedArticles() == null) {
            return Collections.emptyList();
        }

        return user.getLikedArticles().stream()
                .map(articleLike -> articleLike.getLikeArticle().getTitle()) // önce nesneye gidiyoruz burda, ->
                .collect(Collectors.toList());
    }

    public static UserResponseDto mapUserResponseDto(User user) {

        UserResponseDto dto = new UserResponseDto();

        dto.setId(user.getId());
        dto.setUserName(user.getName());
        dto.setPassportId(user.getPassport().getId());
        dto.setArticleTitlesWritten(extractArticleTitlesWritten(user));
        dto.setCommentsWritten(extractCommentsWritten(user));
        dto.setLikedArticleTitles(extractLikedArticleTitles(user));

        return dto;
    }

}
