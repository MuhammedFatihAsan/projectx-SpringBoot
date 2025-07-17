package projectx.northwind.core.exceptions.types;

import projectx.northwind.core.exceptions.base.BusinessException;

public class MailAlreadyExistsException extends BusinessException {

    public MailAlreadyExistsException(String message) {
        super(message);
    }

}
