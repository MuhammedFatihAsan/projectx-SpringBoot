package projectx.northwind.core.exceptions.types.category;

import projectx.northwind.core.exceptions.base.BusinessException;

public class NoCategoryExistsException extends BusinessException {

    public NoCategoryExistsException(String message) {

        super(message);
    }
}
