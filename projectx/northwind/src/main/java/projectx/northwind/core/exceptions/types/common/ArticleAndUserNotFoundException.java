package projectx.northwind.core.exceptions.types.common;

import projectx.northwind.core.exceptions.base.BusinessException;

public class ArticleAndUserNotFoundException extends BusinessException {

    public ArticleAndUserNotFoundException(String message) {

        super(message);
    }
}
