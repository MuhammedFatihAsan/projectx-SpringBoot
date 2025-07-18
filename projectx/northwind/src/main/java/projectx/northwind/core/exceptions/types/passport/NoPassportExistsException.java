package projectx.northwind.core.exceptions.types.passport;

import projectx.northwind.core.exceptions.base.BusinessException;

public class NoPassportExistsException extends BusinessException {

    public NoPassportExistsException(String message) {

        super(message);
    }
}
