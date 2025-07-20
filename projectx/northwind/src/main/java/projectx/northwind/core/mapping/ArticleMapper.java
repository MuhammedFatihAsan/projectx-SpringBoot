package projectx.northwind.core.mapping;

import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.concretes.Comment;
import projectx.northwind.entities.dtos.responses.ArticleResponseDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class ArticleMapper {

    public static List<String> extractCategoryTags(Article article) {

        if (article.getArticleCategories() == null) {
            return Collections.emptyList();
        }

        // (en) Streams over article's category relations and extracts category tag names as a list.
        // (tr) Makalenin kategori ilişkileri üzerinden geçer ve kategori etiket isimlerini liste olarak çıkarır.
        return article.getArticleCategories().stream()
                .map(articleCategory -> articleCategory.getArticleCategory().getTag())
                .collect(Collectors.toList());
    }

    public static List<String> extractCommentsWritten(Article article) {

        if (article.getComments() == null) {
            return Collections.emptyList();
        }

        return article.getComments().stream()
                .map(Comment::getBody) // Direkt methoda referans verebiliyorum, ::
                .collect(Collectors.toList());
    }

    public static List<String> extractLikedUserNames(Article article) {

        if (article.getArticleLikes() == null) {
            return Collections.emptyList();
        }

        return article.getArticleLikes().stream()
                .map(articleLike -> articleLike.getLikeUser().getName())
                .collect(Collectors.toList());
    }

    public static ArticleResponseDto mapArticleResponseDto(Article article) {

        ArticleResponseDto dto = new ArticleResponseDto();

        dto.setArticleId(article.getId());
        dto.setTitle(article.getTitle());
        dto.setBody(article.getBody());
        dto.setAuthor(article.getArticleUser().getName());
        dto.setTags(extractCategoryTags(article));
        dto.setCommentCount(article.getComments().size());
        dto.setComments(extractCommentsWritten(article));
        dto.setLikeCount(article.getArticleLikes().size());
        dto.setLikedUserNames(extractLikedUserNames(article));

        return dto;
    }

}
