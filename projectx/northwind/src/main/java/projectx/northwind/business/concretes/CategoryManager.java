package projectx.northwind.business.concretes;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import projectx.northwind.business.abstracts.CategoryService;
import projectx.northwind.core.exceptions.types.category.CategoryNotFoundException;
import projectx.northwind.core.exceptions.types.category.NoCategoryExistsException;
import projectx.northwind.core.mapping.CategoryMapper;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.SuccessDataResult;
import projectx.northwind.dataAccess.abstracts.CategoryDao;
import projectx.northwind.entities.concretes.Category;
import projectx.northwind.entities.dtos.responses.CategoryResponseDto;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public boolean existsBy() {

        return this.categoryDao.existsBy();
    }

    // =================== RESPONSE METHODS ===================

    @Override
    public DataResult<List<CategoryResponseDto>> getAll() throws NoCategoryExistsException {

        checkAnyCategoryExists();

        List<Category> categories = this.categoryDao.findAll();

        List<CategoryResponseDto> responseDtoList = new ArrayList<>();

        for(Category category : categories){

            responseDtoList.add(CategoryMapper.mapCategoryResponseDto(category));
        }

        return new SuccessDataResult<List<CategoryResponseDto>>(responseDtoList);
    }

    @Override
    public DataResult<CategoryResponseDto> findByTag(String tag) throws CategoryNotFoundException {

        checkCategoryExists(tag);

        Category category = this.categoryDao.findByTag(tag);

        CategoryResponseDto responseDto = CategoryMapper.mapCategoryResponseDto(category);

        return new SuccessDataResult<CategoryResponseDto>(responseDto);
    }

    // =================== BUSINESS RULE CHECKS ===================

    private void checkAnyCategoryExists() throws NoCategoryExistsException {

        if(!existsBy()){

            throw new NoCategoryExistsException("No category are registered!");
        }
    }

    private void checkCategoryExists(String categoryTag) throws CategoryNotFoundException {

        if(!categoryDao.existsByTag(categoryTag)){

            throw new CategoryNotFoundException("Not found : " + categoryTag);
        }
    }

}
