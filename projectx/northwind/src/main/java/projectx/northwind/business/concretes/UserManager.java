package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.UserService;
import projectx.northwind.core.dataAccess.UserDao;
import projectx.northwind.core.entities.User;
import projectx.northwind.core.exceptions.types.user.NoUsersExistsException;
import projectx.northwind.core.exceptions.types.user.UserNotFoundException;
import projectx.northwind.core.mapping.UserMapper;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.SuccessDataResult;
import projectx.northwind.entities.dtos.responses.UserResponseDto;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {

        this.userDao = userDao;
    }

    // =================== INTERNAL METHODS ===================

    @Override
    public boolean existsByName(String name) {

        return this.userDao.existsByName(name);
    }

    @Override
    public boolean existsById(int userId) {

        return this.userDao.existsById(userId);
    }

    @Override
    public User findById(int userId) {

        return this.userDao.findById(userId);
    }

    @Override
    public boolean existsBy() {

        return this.userDao.existsBy();
    }

    // =================== RESPONSE METHODS ===================

    @Override
    public DataResult<List<UserResponseDto>> getAll() throws NoUsersExistsException {

        checkAnyUserExists();

        List<User> users = this.userDao.findAll();

        List<UserResponseDto> responseDtoList = new ArrayList<>();

        for(User user : users){

            responseDtoList.add(UserMapper.mapUserResponseDto(user));
        }

        return new SuccessDataResult<List<UserResponseDto>>(responseDtoList);
    }

    @Override
    public DataResult<UserResponseDto> getById(int userId) throws UserNotFoundException {

        checkUserExistsById(userId);

        User user = this.userDao.findById(userId);

        return new SuccessDataResult<UserResponseDto>(UserMapper.mapUserResponseDto(user));
    }

    @Override
    public DataResult<UserResponseDto> getByName(String userName) throws UserNotFoundException {

        checkUserExistsByName(userName);

        User user = this.userDao.findByName(userName);

        return new SuccessDataResult<UserResponseDto>(UserMapper.mapUserResponseDto(user));
    }

    // =================== BUSINESS RULE CHECKS ===================

    private void checkAnyUserExists() throws NoUsersExistsException {

        if(!existsBy()){

            throw new NoUsersExistsException("No passport are registered!");
        }
    }

    private void checkUserExistsById(int userId) throws UserNotFoundException {

        if(!existsById(userId)){

            throw new UserNotFoundException(userId + " : User Id Not Found!");
        }
    }

    private void checkUserExistsByName(String name) throws UserNotFoundException {

        if(!existsByName(name)){

            throw new UserNotFoundException(name + " : User Name Not Found!");
        }
    }

}
