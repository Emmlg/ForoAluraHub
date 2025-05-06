package com.emmlg.ForoAluraHub.curso.service;

import com.emmlg.ForoAluraHub.curso.dto.CourseCategoryDto;
import com.emmlg.ForoAluraHub.util.GeneralResponse;

import java.util.List;

public interface ICourseCategoryService {

    CourseCategoryDto findCategoryName(String categoryName);

    List<CourseCategoryDto> findAllCategoryName();

    CourseCategoryDto saveCategory(CourseCategoryDto courseCategoryDto);

    CourseCategoryDto updateCategory(String categoryName, CourseCategoryDto courseCategoryDto);

    GeneralResponse deleteCategory(String categoryName);
}

