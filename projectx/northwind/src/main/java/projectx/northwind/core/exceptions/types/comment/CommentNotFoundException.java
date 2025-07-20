package projectx.northwind.core.exceptions.types.comment;

import projectx.northwind.core.exceptions.base.BusinessException;

public class CommentNotFoundException extends BusinessException {

    public CommentNotFoundException(String message) {

        super(message);
    }
}
