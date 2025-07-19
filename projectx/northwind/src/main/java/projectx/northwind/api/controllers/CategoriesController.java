package projectx.northwind.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import projectx.northwind.business.abstracts.CategoryService;
import projectx.northwind.core.exceptions.types.category.CategoryNotFoundException;
import projectx.northwind.core.exceptions.types.category.NoCategoryExistsException;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.entities.dtos.responses.CategoryResponseDto;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
public class CategoriesController {

    private final CategoryService categoryService;

    @Autowired
    public CategoriesController(CategoryService categoryService) {

        this.categoryService = categoryService;
    }

    // =================== RESPONSE METHODS ===================

    @GetMapping("/getAll")
    public DataResult<List<CategoryResponseDto>> getAll() throws NoCategoryExistsException {

        return this.categoryService.getAll();
    }

    @GetMapping("/findByTag")
    public DataResult<CategoryResponseDto> findByTag(String tag) throws CategoryNotFoundException {

        return this.categoryService.findByTag(tag);
    }

}
