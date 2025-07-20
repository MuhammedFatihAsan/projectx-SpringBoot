package projectx.northwind.api.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectx.northwind.business.abstracts.ArticleCategoryService;
import projectx.northwind.core.exceptions.types.article.ArticleNotFoundException;
import projectx.northwind.core.exceptions.types.articleCategory.ArticleCategoryAlreadyExistsThisArticleThisCategory;
import projectx.northwind.core.exceptions.types.category.CategoryNotFoundException;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.dtos.requests.CreateArticleCategoryRequestDto;

@RestController
@RequestMapping("/api/articleCategories")
public class ArticleCategoriesController {

    private final ArticleCategoryService articleCategoryService;

    @Autowired
    public ArticleCategoriesController(ArticleCategoryService articleCategoryService) {

        this.articleCategoryService = articleCategoryService;
    }

    // =================== REQUEST METHODS ===================

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody CreateArticleCategoryRequestDto newArticleCategoryRequestDto) throws ArticleNotFoundException, ArticleCategoryAlreadyExistsThisArticleThisCategory, CategoryNotFoundException {

        return ResponseEntity.ok(this.articleCategoryService.add(newArticleCategoryRequestDto));
    }

}
