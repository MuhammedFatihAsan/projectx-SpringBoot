package projectx.northwind.business.abstracts;

import projectx.northwind.core.entities.User;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.entities.dtos.responses.UserResponseDto;

import java.util.List;

public interface UserService {

    // =================== INTERNAL METHODS ===================
    // (Only used within the system, not exposed via endpoint)

    boolean existsByName(String name);

    boolean existsById(int userId);

    // =================== RESPONSE METHODS ===================
    // (Data exporting, DTO returning operations)

    DataResult<UserResponseDto> findByName(String name);

    DataResult<List<UserResponseDto>> getAll();

}
