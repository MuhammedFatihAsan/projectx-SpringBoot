package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.UserService;
import projectx.northwind.core.dataAccess.UserDao;
import projectx.northwind.core.entities.User;
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
    // (Only used within the system, not exposed via endpoint)

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
    // (Data exporting, DTO returning operations)

    @Override
    public DataResult<UserResponseDto> findByName(String name) {

        User user = this.userDao.findByName(name);

        return new SuccessDataResult<UserResponseDto>(UserMapper.mapUserResponseDto(user));
    }

    @Override
    public DataResult<List<UserResponseDto>> getAll() {

        List<User> users = this.userDao.findAll();

        List<UserResponseDto> responseDtoList = new ArrayList<>();

        for(User user : users){

            responseDtoList.add(UserMapper.mapUserResponseDto(user));
        }

        return new SuccessDataResult<List<UserResponseDto>>(responseDtoList);
    }

}
