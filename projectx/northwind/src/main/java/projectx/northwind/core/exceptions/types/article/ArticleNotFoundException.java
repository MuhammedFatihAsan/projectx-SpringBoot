package projectx.northwind.core.exceptions.types.article;

import projectx.northwind.core.exceptions.base.BusinessException;

public class ArticleNotFoundException extends BusinessException {

    public ArticleNotFoundException(String message) {

        super(message);
    }
}
