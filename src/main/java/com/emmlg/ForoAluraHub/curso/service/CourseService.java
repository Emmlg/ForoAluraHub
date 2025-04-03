package com.emmlg.ForoAluraHub.curso.service;

import com.emmlg.ForoAluraHub.Exceptions.ForoAluraHubExceptions;
import com.emmlg.ForoAluraHub.curso.dto.CourseCategoryDto;
import com.emmlg.ForoAluraHub.curso.dto.CourseDto;
import com.emmlg.ForoAluraHub.curso.modelo.Course;
import com.emmlg.ForoAluraHub.curso.modelo.CourseCategory;
import com.emmlg.ForoAluraHub.curso.repository.CategoryRepository;
import com.emmlg.ForoAluraHub.curso.repository.CourseRepository;
import com.emmlg.ForoAluraHub.util.GeneralRespose;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.emmlg.ForoAluraHub.common.constants.Messages.*;
import static com.emmlg.ForoAluraHub.util.ConvertDtoToEntity.convertDtoToEntity;
import static com.emmlg.ForoAluraHub.util.ConvertEntityToDto.convertCourseToDto;
import static com.emmlg.ForoAluraHub.util.ConvertEntityToDto.convertEntityToDto;

@Service
@AllArgsConstructor
public class CourseService implements ICourseService {

    private final CourseRepository courseRepository;
    private final CategoryRepository categoryRepository;
    private final CourseCategoryService courseCategoryService;

    @Override
    @Transactional
    public CourseDto addCourse(CourseDto courseDto) throws ForoAluraHubExceptions {
        boolean courseExists = courseRepository.existsByCourseNameIgnoreCase(courseDto.getCourseName());
        if (courseExists) {
            throw new ForoAluraHubExceptions(
                    HttpStatus.CONFLICT,
                    List.of("El curso con el nombre " + courseDto.getCourseName() + " Ya existe"),
                    COURSE_ALREADY_EXISTS,
                    COURSE_SEARCH);
        }

        var courseCategory = categoryRepository.findByCategoryName(courseDto.getCategory());
        if (courseCategory == null) {

            courseCategory = new CourseCategory();
            courseCategory.setCategoryName(courseDto.getCategory());
            courseCategory = categoryRepository.save(courseCategory);
        }

        Course course = convertDtoToEntity(courseDto);
        course.setCategory(courseCategory);
        return convertEntityToDto(courseRepository.save(course));
    }


    @Override
    @Transactional
    public List<CourseDto> addCourse(List<CourseDto> coursesDto) throws ForoAluraHubExceptions {

      /*  List<CourseDto> courses = new ArrayList<>();
        for (CourseDto courseDto : coursesDto) {
           courses.add(addCourse(courseDto));
        }
        return courses;
      */
        return coursesDto.stream()
                .map(this::addCourse)  // Aplicar addCourse a cada CourseDto
                .collect(Collectors.toList());  // Colectar los resultados en una lista

    }

    @Override
    public CourseDto getCourseByCourseName(String courseName) throws ForoAluraHubExceptions {
        boolean courseExists = courseRepository.existsByCourseNameIgnoreCase(courseName);
        if (!courseExists)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("El curso con el nombre " + courseName + " no existe"),
                    COURSE_NOT_FOUND,
                    COURSE_SEARCH);
        return convertEntityToDto(courseRepository.getCourseByCourseName(courseName));
    }

    @Override
    public List<CourseDto> getCourseByCategory(String categoryName) {

        boolean categoryExists = categoryRepository.existsByCategoryName(categoryName);
        if (!categoryExists) {
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("La categoria con el nombre " + categoryName + " no existe"),
                    CATEGORY_NOT_FOUND,
                    CATEGORY_SEARCH);
        }
        var coursesByCategory = courseRepository.findByCategory_CategoryNameContainingIgnoreCase(categoryName);
        return convertCourseToDto(coursesByCategory);
    }

    @Override
    public CourseDto getCourseById(Integer courseId) {
        boolean courseExists = courseRepository.existsByCourseId(courseId);
        if (!courseExists) {
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("El curso con el id " + courseId + " no existe"),
                    COURSE_NOT_FOUND,
                    COURSE_SEARCH);
        }
        return convertEntityToDto(courseRepository.findByCourseId(courseId));
    }

    @Override
    public List<CourseDto> getAllCourseByname() {
        var courses = courseRepository.findAll();
        if (courses == null) {
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("No hay cursos disponibles"),
                    COURSE_NOT_FOUND,
                    COURSE_SEARCH);
        }
        return convertCourseToDto(courses);
    }

    @Override
    @Transactional
    public CourseDto modifyCourse(String courseName, CourseDto courseDto) throws ForoAluraHubExceptions {
        System.out.println("courseName: " + courseName);
        var existingCourse = courseRepository.findByCourseName(courseName);
        if (existingCourse == null)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("El curso con el nombre " + courseName + " No existe"),
                    COURSE_NOT_FOUND,
                    COURSE_SEARCH);

        var courseCategory = categoryRepository.findByCategoryName(courseDto.getCategory());
        if (courseCategory == null) {

            courseCategory = new CourseCategory();
            courseCategory.setCategoryName(courseDto.getCategory());
            courseCategory = categoryRepository.save(courseCategory);
        }

        existingCourse.setCourseName(courseDto.getCourseName());
        existingCourse.setCategory(courseCategory);
        return convertEntityToDto(courseRepository.save(existingCourse));
    }

    @Override
    @Transactional
    public GeneralRespose removeCourse(String courseName) throws ForoAluraHubExceptions {
        boolean courseExists = courseRepository.existsByCourseNameIgnoreCase(courseName);
        if (!courseExists)
            throw new ForoAluraHubExceptions(
                    HttpStatus.NOT_FOUND,
                    List.of("El curso" + courseName + " no existe"),
                    COURSE_NOT_FOUND,
                    COURSE_SEARCH);
        courseRepository.deleteByCourseName(courseName);
        return GeneralRespose
                .builder()
                .message("El curso " + courseName + " fue eliminado correctamente")
                .status(HttpStatus.OK)
                .build();
    }
}
