package projectx.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import projectx.northwind.entities.concretes.Passport;

public interface PassportDao extends JpaRepository<Passport, Integer> {
}
