package projectx.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import projectx.northwind.entities.concretes.Category;

public interface CategoryDao extends JpaRepository<Category, Integer> {

    // =================== INTERNAL METHODS ===================

    boolean existsByTag(String tag);

    boolean existsBy();

    boolean existsById(int categoryId);

    Category findByTag(String tag);

    Category findById(int id);

}
