package projectx.northwind.core.mapping;

import jakarta.persistence.Entity;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.concretes.Category;
import projectx.northwind.entities.dtos.responses.ArticleResponseDto;
import projectx.northwind.entities.dtos.responses.CategoryResponseDto;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CategoryMapper {

    public static List<String> extractCategoryArticleTitles(Category category) {

        if (category.getCategoryArticles() == null) {
            return Collections.emptyList();
        }

        return category.getCategoryArticles().stream()
                .map(articleCategory -> articleCategory.getCategoryArticle().getTitle())
                .collect(Collectors.toList());
    }

    public static CategoryResponseDto mapCategoryResponseDto(Category category) {

        CategoryResponseDto dto = new CategoryResponseDto();

        dto.setCategoryId(category.getId());
        dto.setCategoryTag(category.getTag());
        dto.setCategoryArticleTitles(extractCategoryArticleTitles(category));

        return dto;
    }

}
