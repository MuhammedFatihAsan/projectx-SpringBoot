package projectx.northwind.core.exceptions.types.common;

import projectx.northwind.core.exceptions.base.BusinessException;

public class EmptyListException extends BusinessException {

    public EmptyListException(String message) {

        super(message);
    }
}
