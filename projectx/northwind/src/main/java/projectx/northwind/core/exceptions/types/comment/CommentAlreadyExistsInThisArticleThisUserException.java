package projectx.northwind.core.exceptions.types.comment;

import projectx.northwind.core.exceptions.base.BusinessException;

public class CommentAlreadyExistsInThisArticleThisUserException extends BusinessException {

    public CommentAlreadyExistsInThisArticleThisUserException(String message) {

        super(message);
    }
}
