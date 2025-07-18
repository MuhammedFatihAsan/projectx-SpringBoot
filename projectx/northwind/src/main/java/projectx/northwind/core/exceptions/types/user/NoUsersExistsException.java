package projectx.northwind.core.exceptions.types.user;

import projectx.northwind.core.exceptions.base.BusinessException;

public class NoUsersExistsException extends BusinessException {

    public NoUsersExistsException(String message) {

        super(message);
    }
}
