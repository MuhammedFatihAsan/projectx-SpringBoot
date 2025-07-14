package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.UserService;
import projectx.northwind.core.dataAccess.UserDao;
import projectx.northwind.core.entities.User;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.core.utilities.results.SuccessDataResult;
import projectx.northwind.core.utilities.results.SuccessResult;

@Service
public class UserManager implements UserService {

    private final UserDao userDao;

    @Autowired
    public UserManager(UserDao userDao) {

        this.userDao = userDao;
    }

    @Override
    public Result add(User user) {

        this.userDao.save(user);
        return new SuccessResult("User added");
    }

    @Override
    public DataResult<User> findByName(String name) {

        return new SuccessDataResult<User>(this.userDao.findByName(name));
    }
}
