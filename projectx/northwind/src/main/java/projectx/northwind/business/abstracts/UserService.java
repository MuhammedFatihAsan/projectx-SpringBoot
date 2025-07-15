package projectx.northwind.business.abstracts;

import projectx.northwind.core.entities.User;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;

import java.util.Optional;

public interface UserService {

    // =================== RESPONSE METHODS ===================
    // (Data exporting, DTO returning operations)

    DataResult<User> findByName(String name);

    // =================== REQUEST METHODS ===================
    // (Operations that retrieve, save or modify new data)

    Result add(User user);

}
