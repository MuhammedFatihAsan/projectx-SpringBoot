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
    // (Data exporting, DTO returning operations)

    @GetMapping("/findByName")
    public DataResult<UserResponseDto> findByName(@RequestParam String name) throws UserNotFoundException {

        return this.userService.findByName(name);
    }

    @GetMapping("/getAll")
    public DataResult<List<UserResponseDto>> getAll() throws NoUsersExistsException {

        return this.userService.getAll();
    }

}
