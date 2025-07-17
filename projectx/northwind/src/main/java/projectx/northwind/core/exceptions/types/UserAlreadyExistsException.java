package projectx.northwind.core.exceptions.types;

import projectx.northwind.core.exceptions.base.BusinessException;

public class UserAlreadyExistsException extends BusinessException {

    public UserAlreadyExistsException(String message) {

        super(message);
    }

}
