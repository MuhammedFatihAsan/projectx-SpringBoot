package projectx.northwind.core.exceptions.types.user;

import projectx.northwind.core.exceptions.base.BusinessException;

public class UserNotFoundException extends BusinessException {

    public UserNotFoundException(String message) {

        super(message);
    }
}
