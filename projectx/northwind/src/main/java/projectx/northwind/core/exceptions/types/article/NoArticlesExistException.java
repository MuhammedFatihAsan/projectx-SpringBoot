package projectx.northwind.core.exceptions.types.article;

import projectx.northwind.core.exceptions.base.BusinessException;

public class NoArticlesExistException extends BusinessException {

    public NoArticlesExistException(String message) {

        super(message);
    }
}
