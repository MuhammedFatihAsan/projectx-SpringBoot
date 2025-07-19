package projectx.northwind.core.exceptions.types.category;

import projectx.northwind.core.exceptions.base.BusinessException;

public class CategoryAlreadyExistsException extends BusinessException {

    public CategoryAlreadyExistsException(String message) {

        super(message);
    }
}
