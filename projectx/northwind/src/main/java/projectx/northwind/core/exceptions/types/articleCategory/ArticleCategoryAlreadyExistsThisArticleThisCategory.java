package projectx.northwind.core.exceptions.types.articleCategory;

import projectx.northwind.core.exceptions.base.BusinessException;

public class ArticleCategoryAlreadyExistsThisArticleThisCategory extends BusinessException {

    public ArticleCategoryAlreadyExistsThisArticleThisCategory(String message) {

        super(message);
    }
}
