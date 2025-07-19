package projectx.northwind.core.exceptions.types.category;

import projectx.northwind.core.exceptions.base.BusinessException;

public class CategoryNotFoundException extends BusinessException {

    public CategoryNotFoundException(String message) {

        super(message);
    }
}
