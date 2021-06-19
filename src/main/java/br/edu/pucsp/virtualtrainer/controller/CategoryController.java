package br.edu.pucsp.virtualtrainer.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.pucsp.virtualtrainer.service.CategoryService;
import br.edu.pucsp.virtualtrainer.domain.response.CategoryListResponse;
import br.edu.pucsp.virtualtrainer.domain.response.CategoryResponse;
import br.edu.pucsp.virtualtrainer.domain.response.FieldListResponse;
import io.swagger.annotations.ApiOperation;

@CrossOrigin(origins = "http://35.184.242.241:4200")
@RestController()
@RequestMapping("/category")
public class CategoryController {
    
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService){
        this.categoryService = categoryService;
    }

    @ApiOperation(value = "Recover all available categories")
    @GetMapping
    public CategoryListResponse getCategories(){
        return new CategoryListResponse(categoryService.findAllCategories());
    }

    @ApiOperation(value = "Recover a category by id")
    @GetMapping(path = "/id/{categoryId}")
    public CategoryResponse getCategory(@PathVariable Long categoryId){
        return new CategoryResponse(categoryService.findCategory(categoryId));
    }

    @ApiOperation(value = "Recover fields by category")
    @GetMapping(path = "/id/{categoryId}/fields")
    public FieldListResponse getFieldsByCategory(@PathVariable Long categoryId){
        return new FieldListResponse(categoryService.findFieldsByCategory(categoryId));
    }
}
