package projectx.northwind.api.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import projectx.northwind.business.abstracts.CategoryService;
import projectx.northwind.core.exceptions.types.category.CategoryAlreadyExistsException;
import projectx.northwind.core.exceptions.types.category.CategoryNotFoundException;
import projectx.northwind.core.exceptions.types.category.NoCategoryExistsException;
import projectx.northwind.core.utilities.results.DataResult;
import projectx.northwind.core.utilities.results.Result;
import projectx.northwind.entities.dtos.requests.CreateCategoryRequestDto;
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

    // =================== REQUEST METHODS ===================

    @PostMapping("/add")
    public ResponseEntity<Result> add(@Valid @RequestBody CreateCategoryRequestDto newCategory) throws CategoryAlreadyExistsException {

        return ResponseEntity.ok(this.categoryService.add(newCategory));
    }

}
