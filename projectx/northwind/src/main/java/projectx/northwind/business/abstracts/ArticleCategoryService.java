package projectx.northwind.business.abstracts;

import projectx.northwind.core.exceptions.types.article.ArticleNotFoundException;
import projectx.northwind.core.exceptions.types.articleCategory.ArticleCategoryAlreadyExistsThisArticleThisCategory;
import projectx.northwind.core.exceptions.types.category.CategoryNotFoundException;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.concretes.Category;
import projectx.northwind.entities.dtos.requests.CreateArticleCategoryRequestDto;

public interface ArticleCategoryService {

    // =================== INTERNAL METHODS ===================

    boolean existsByCategoryArticleAndArticleCategory(Article categoryArticle, Category articleCategory);

    // =================== REQUEST METHODS ===================

    Result add(CreateArticleCategoryRequestDto newArticleCategoryRequest) throws ArticleNotFoundException, CategoryNotFoundException, ArticleCategoryAlreadyExistsThisArticleThisCategory;

}
