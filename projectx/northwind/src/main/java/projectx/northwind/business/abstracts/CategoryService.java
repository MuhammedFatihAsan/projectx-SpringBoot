package projectx.northwind.business.abstracts;

import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.entities.dtos.responses.CategoryResponseDto;

import java.util.List;

public interface CategoryService {

    // =================== INTERNAL METHODS ===================

    boolean existsByTag(String tag);

    // =================== RESPONSE METHODS ===================

    DataResult<List<CategoryResponseDto>> getAll();

}
