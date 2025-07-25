package projectx.northwind.business.abstracts;

import projectx.northwind.core.entities.User;
import projectx.northwind.core.exceptions.types.user.NoUsersExistsException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.entities.dtos.responses.UserResponseDto;

import java.util.List;

public interface UserService {

    // =================== INTERNAL METHODS ===================

    boolean existsByName(String name);

    boolean existsById(int userId);

    User findById(int userId);

    boolean existsBy();

    // =================== RESPONSE METHODS ===================

    DataResult<List<UserResponseDto>> getAll() throws NoUsersExistsException;

    DataResult<UserResponseDto> getById(int userId) throws UserNotFoundException;

    DataResult<UserResponseDto> getByName(String userName) throws UserNotFoundException;

}
