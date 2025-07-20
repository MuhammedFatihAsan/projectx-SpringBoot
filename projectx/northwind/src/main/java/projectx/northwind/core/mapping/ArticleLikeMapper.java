package projectx.northwind.core.mapping;

import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.dtos.responses.ArticleLikeResponseDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArticleLikeMapper {

    public static List<String> extractArticleLikedUserNames(Article article) {

        if(article == null || article.getArticleLikes() == null || article.getArticleLikes().isEmpty()) {

            return Collections.emptyList();
        }

        return article.getArticleLikes().stream()
                .map(articleLike -> articleLike.getLikeUser().getName())
                .collect(Collectors.toList());
    }

    public static ArticleLikeResponseDto mapArticleLikeResponseDto(Article article) {

        ArticleLikeResponseDto dto = new ArticleLikeResponseDto();

        dto.setArticleTitle(article.getTitle());
        dto.setLikeCount(article.getArticleLikes().size());
        dto.setLikedUserNames(extractArticleLikedUserNames(article));

        return dto;
    }

}
