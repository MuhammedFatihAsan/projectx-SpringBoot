package projectx.northwind.business.abstracts;

import projectx.northwind.core.entities.User;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;

public interface UserService {

    Result add(User user);

    DataResult<User> findByName(String name);

}
