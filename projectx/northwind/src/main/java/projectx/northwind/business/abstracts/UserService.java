package projectx.northwind.business.abstracts;

import projectx.northwind.core.entities.User;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.dtos.responses.UserResponseDto;

public interface UserService {

    // =================== RESPONSE METHODS ===================
    // (Data exporting, DTO returning operations)

    DataResult<UserResponseDto> findByName(String name);

    // =================== REQUEST METHODS ===================
    // (Operations that retrieve, save or modify new data)

    Result add(User user);

}
