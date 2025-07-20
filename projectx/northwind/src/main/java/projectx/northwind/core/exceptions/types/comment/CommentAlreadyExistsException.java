package projectx.northwind.core.exceptions.types.comment;

import projectx.northwind.core.exceptions.base.BusinessException;

public class CommentAlreadyExistsException extends BusinessException {

    public CommentAlreadyExistsException(String message) {

        super(message);
    }
}
