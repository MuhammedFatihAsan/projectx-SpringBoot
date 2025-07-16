package projectx.northwind.core.mapping;

import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.dtos.responses.ArticleResponseDto;

import java.util.ArrayList;
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
                .map(ac -> ac.getArticleCategory().getTag())
                .collect(Collectors.toList());
    }

    public static ArticleResponseDto mapArticleResponseDto(Article article) {

        ArticleResponseDto dto = new ArticleResponseDto();

        dto.setArticleId(article.getId());
        dto.setTitle(article.getTitle());
        dto.setBody(article.getBody());
        dto.setAuthor(article.getArticleUser().getName());
        dto.setTags(extractCategoryTags(article));

        return dto;
    }

}
