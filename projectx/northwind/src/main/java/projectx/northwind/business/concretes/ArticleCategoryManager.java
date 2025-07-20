package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.ArticleCategoryService;
import projectx.northwind.business.abstracts.ArticleService;
import projectx.northwind.business.abstracts.CategoryService;
import projectx.northwind.core.exceptions.types.article.ArticleNotFoundException;
import projectx.northwind.core.exceptions.types.articleCategory.ArticleCategoryAlreadyExistsThisArticleThisCategory;
import projectx.northwind.core.exceptions.types.category.CategoryNotFoundException;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.core.utilities.results.SuccessResult;
import projectx.northwind.dataAccess.abstracts.ArticleCategoryDao;
import projectx.northwind.entities.concretes.Article;
import projectx.northwind.entities.concretes.ArticleCategory;
import projectx.northwind.entities.concretes.Category;
import projectx.northwind.entities.dtos.requests.CreateArticleCategoryRequestDto;

@Service
public class ArticleCategoryManager implements ArticleCategoryService {

    private final ArticleCategoryDao articleCategoryDao;
    private final ArticleService articleService;
    private final CategoryService categoryService;

    @Autowired
    public ArticleCategoryManager(ArticleCategoryDao articleCategoryDao,  ArticleService articleService, CategoryService categoryService) {

        this.articleCategoryDao = articleCategoryDao;
        this.articleService = articleService;
        this.categoryService = categoryService;
    }

    // =================== INTERNAL METHODS ===================

    @Override
    public boolean existsByCategoryArticleAndArticleCategory(Article categoryArticle, Category articleCategory) {

        return articleCategoryDao.existsByCategoryArticleAndArticleCategory(categoryArticle, articleCategory);
    }

    // =================== REQUEST METHODS ===================

    @Override
    public Result add(CreateArticleCategoryRequestDto newArticleCategoryRequest) throws ArticleNotFoundException, CategoryNotFoundException, ArticleCategoryAlreadyExistsThisArticleThisCategory {

        checkArticleExists(newArticleCategoryRequest.getArticleId());
        checkCategoryExists(newArticleCategoryRequest.getCategoryId());
        checkArticleCategoryAlreadyExists(newArticleCategoryRequest.getArticleId(), newArticleCategoryRequest.getCategoryId());

        ArticleCategory articleCategory = new ArticleCategory();

        articleCategory.setCategoryArticle(this.articleService.findById(newArticleCategoryRequest.getArticleId()));
        articleCategory.setArticleCategory(this.categoryService.findById(newArticleCategoryRequest.getCategoryId()));

        this.articleCategoryDao.save(articleCategory);

        return new SuccessResult("Article Category has been added successfully.");
    }

    // =================== BUSINESS RULE CHECKS ===================

    private void checkArticleExists(int articleId) throws ArticleNotFoundException {

        if(!this.articleService.existsById(articleId)) {

            throw new ArticleNotFoundException("Article not found! Id: " + articleId);
        }
    }

    private void checkCategoryExists(int categoryId) throws CategoryNotFoundException {

        if(!this.categoryService.existsById(categoryId)) {

            throw new CategoryNotFoundException("Category not found! Id: " + categoryId);
        }
    }

    private void checkArticleCategoryAlreadyExists(int articleId, int categoryId) throws ArticleCategoryAlreadyExistsThisArticleThisCategory {

        if(existsByCategoryArticleAndArticleCategory(this.articleService.findById(articleId), this.categoryService.findById(categoryId))){

            throw new ArticleCategoryAlreadyExistsThisArticleThisCategory("This category has already added this article. ArticleId: " + articleId + " categoryId: " + categoryId);
        }
    }

}
