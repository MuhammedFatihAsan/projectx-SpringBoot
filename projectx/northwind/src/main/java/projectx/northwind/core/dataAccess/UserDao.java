package projectx.northwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import projectx.northwind.core.entities.User;

public interface UserDao extends JpaRepository<User, Integer> {

    boolean existsByName(String name);

    boolean existsById(int userId);

    User findByName(String name);

    User findById(int userId);

    boolean existsBy();

}
