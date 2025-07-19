package projectx.northwind.business.abstracts;

import projectx.northwind.core.exceptions.types.category.CategoryNotFoundException;
import projectx.northwind.core.exceptions.types.category.NoCategoryExistsException;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.entities.concretes.Category;
import projectx.northwind.entities.dtos.responses.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    // =================== INTERNAL METHODS ===================

    boolean existsByTag(String tag);

    boolean existsBy();

    // =================== RESPONSE METHODS ===================

    DataResult<List<CategoryResponseDto>> getAll() throws NoCategoryExistsException;

    DataResult<CategoryResponseDto> findByTag(String tag) throws CategoryNotFoundException;

}
