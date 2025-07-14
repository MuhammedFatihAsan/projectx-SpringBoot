package projectx.northwind.core.dataAccess;

import org.springframework.data.jpa.repository.JpaRepository;
import projectx.northwind.core.entities.Passport;

public interface PassportDao extends JpaRepository<Passport, Integer> {



}
