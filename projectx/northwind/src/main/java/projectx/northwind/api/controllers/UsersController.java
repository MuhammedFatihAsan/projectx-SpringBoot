package projectx.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import projectx.northwind.business.abstracts.UserService;
import projectx.northwind.core.exceptions.types.user.NoUsersExistsException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.entities.dtos.responses.UserResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {

        this.userService = userService;
    }

    // =================== RESPONSE METHODS ===================

    @GetMapping("/getAll")
    public DataResult<List<UserResponseDto>> getAll() throws NoUsersExistsException {

        return this.userService.getAll();
    }

    @GetMapping("/getById")
    public DataResult<UserResponseDto> getById(int userId) throws UserNotFoundException {

        return this.userService.getById(userId);
    }

    @GetMapping("/getByName")
    public DataResult<UserResponseDto> getByName(@RequestParam String name) throws UserNotFoundException {

        return this.userService.getByName(name);
    }

}
