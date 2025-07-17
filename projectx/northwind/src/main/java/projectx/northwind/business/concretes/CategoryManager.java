package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.CategoryService;
import projectx.northwind.dataAccess.abstracts.CategoryDao;

@Service
public class CategoryManager implements CategoryService {

    private final CategoryDao categoryDao;

    @Autowired
    public CategoryManager(CategoryDao categoryDao) {

        this.categoryDao = categoryDao;
    }

    // =================== INTERNAL METHODS ===================

    @Override
    public boolean existsByTag(String tag) {

        return this.categoryDao.existsByTag(tag);
    }

}
