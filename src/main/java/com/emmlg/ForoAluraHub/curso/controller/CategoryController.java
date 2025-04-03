package com.emmlg.ForoAluraHub.curso.controller;

import com.emmlg.ForoAluraHub.curso.dto.CourseCategoryDto;
import com.emmlg.ForoAluraHub.curso.service.CourseCategoryService;
import com.emmlg.ForoAluraHub.util.GeneralRespose;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Tag(name = "CourseCategories", description = "Categories of courses")
@AllArgsConstructor
@RestController
@RequestMapping("${api.prefix}/categories")
public class CategoryController {

    private final CourseCategoryService courseCategoryService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get all categories")
    @ApiResponse(responseCode = "200")
    public List<CourseCategoryDto> getAllCategories() {

        return courseCategoryService.findAllCategoryName();
    }

    @GetMapping("/{categoryName}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Get  category")
    @ApiResponse(responseCode = "200")
    public CourseCategoryDto getCategoryByName(@PathVariable String categoryName) {

        return courseCategoryService.findCategoryName(categoryName);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Create  category")
    @ApiResponse(responseCode = "201")
    public CourseCategoryDto createCategory(@RequestBody @Validated CourseCategoryDto categoryDto) {

        return courseCategoryService.saveCategory(categoryDto);
    }

    @PutMapping("/{categoryName}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update category")
    @ApiResponse(responseCode = "200")
    public CourseCategoryDto updateCategory(@PathVariable String categoryName, @RequestBody @Validated CourseCategoryDto courseCategoryDto) {

        return courseCategoryService.updateCategory(categoryName, courseCategoryDto);
    }

    @DeleteMapping("/{categoryName}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Delete category")
    @ApiResponse(responseCode = "200", description = "Category deleted successfully")
    @ApiResponse(responseCode = "404", description = "Category not found")
    public GeneralRespose deleteCategory(@PathVariable String categoryName) {

        return courseCategoryService.deleteCategory(categoryName);
    }


}
