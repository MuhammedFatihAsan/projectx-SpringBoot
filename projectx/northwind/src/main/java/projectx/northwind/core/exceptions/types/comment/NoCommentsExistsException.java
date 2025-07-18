package projectx.northwind.core.exceptions.types.comment;

import projectx.northwind.core.exceptions.base.BusinessException;

public class NoCommentsExistsException extends BusinessException {

    public NoCommentsExistsException(String message) {

        super(message);
    }
}
