package com.emmlg.ForoAluraHub.curso.service;


import com.emmlg.ForoAluraHub.Exceptions.ForoAluraHubExceptions;
import com.emmlg.ForoAluraHub.curso.dto.CourseCategoryDto;
import com.emmlg.ForoAluraHub.curso.repository.CategoryRepository;
import com.emmlg.ForoAluraHub.util.ConvertDtoToEntity;
import com.emmlg.ForoAluraHub.util.GeneralRespose;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.emmlg.ForoAluraHub.common.constants.Messages.*;
import static com.emmlg.ForoAluraHub.util.ConvertEntityToDto.convertEntityToDto;

@Service
@AllArgsConstructor
public class CourseCategoryService implements ICourseCategoryService {

    private final CategoryRepository categoryRepository;


    @Override
    public CourseCategoryDto findCategoryName(String categoryName) throws ForoAluraHubExceptions {
        var category = categoryRepository.findByCategoryName(categoryName.toUpperCase());
        if (category == null)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("La categoria con el nombre " + categoryName + " no existe"),
                    CATEGORY_NOT_FOUND,
                    CATEGORY_SEARCH);
        return convertEntityToDto(category);
    }

    @Override
    public List<CourseCategoryDto> findAllCategoryName() throws ForoAluraHubExceptions {
        var category = categoryRepository.findAll();
        if (category.isEmpty() || category == null)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("There is not categories yet!"),
                    CATEGORY_NOT_FOUND,
                    CATEGORY_SEARCH);
        return convertEntityToDto(category);
    }


    @Override
    @Transactional
    public CourseCategoryDto saveCategory(CourseCategoryDto courseCategoryDto) throws ForoAluraHubExceptions {

        var category = categoryRepository.findByCategoryName(courseCategoryDto.getCategoryName());
        if (category != null)
            throw new ForoAluraHubExceptions(
                    HttpStatus.CONFLICT,
                    List.of("La categoria con el nombre " + courseCategoryDto.getCategoryName() + " Ya existe"),
                    CATEGORY_ALREADY_EXISTS,
                    CATEGORY_SAVED);
        return convertEntityToDto(categoryRepository.save(ConvertDtoToEntity.convertDtoToEntity(courseCategoryDto)));
    }

    @Override
    @Transactional
    public CourseCategoryDto updateCategory(String categoryName, CourseCategoryDto courseCategoryDto) throws ForoAluraHubExceptions {

        var categoryUpdate = categoryRepository.findByCategoryName(categoryName);
        if (categoryUpdate == null)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("La categoria no existe"),
                    "Update not possible due to Category no Exist",
                    CATEGORY_NOT_FOUND);
        categoryUpdate.setCategoryName(courseCategoryDto.getCategoryName().toUpperCase());

        return convertEntityToDto(categoryRepository.save(categoryUpdate));
    }

    @Transactional
    @Override
    public GeneralRespose deleteCategory(String categoryName) throws ForoAluraHubExceptions {
        var category = categoryRepository.findByCategoryName(categoryName);

        if (category == null)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("La categoría no existe"),
                    "Delete not possible due to Category not found",
                    CATEGORY_NOT_FOUND);

        categoryRepository.delete(category);
        return new GeneralRespose(CATEGORY_DELETED, HttpStatus.OK);

    }

}
