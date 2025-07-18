package projectx.northwind.core.exceptions.types.article;

import projectx.northwind.core.exceptions.base.BusinessException;

public class TitleAlreadyExistsException extends BusinessException {

    public TitleAlreadyExistsException(String message) {

        super(message);
    }
}
