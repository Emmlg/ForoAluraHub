package com.emmlg.ForoAluraHub.curso.controller;


import com.emmlg.ForoAluraHub.Exceptions.ForoAluraHubExceptions;
import com.emmlg.ForoAluraHub.curso.dto.CourseDto;
import com.emmlg.ForoAluraHub.curso.service.CourseService;
import com.emmlg.ForoAluraHub.util.GeneralResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(name = "Course", description = "courses Enpoint")
@AllArgsConstructor
@RestController
@RequestMapping("${api.prefix}/courses")
public class CourseController {

    private final CourseService courseService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "2001", description = "Course created successfully")
    public CourseDto createCourse(@Validated @RequestBody CourseDto courseDto) throws ForoAluraHubExceptions {

        return courseService.addCourse(courseDto);
    }

    @PostMapping("/list")
    @ResponseStatus(HttpStatus.CREATED)
    @ApiResponse(responseCode = "2001", description = "Course created successfully")
    public List<CourseDto> createListOfCourses(@Validated @RequestBody List<CourseDto> coursesDto) throws ForoAluraHubExceptions {

        return courseService.addCourse(coursesDto);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(responseCode = "200", description = "Courses retrieved successfully")
    public List<CourseDto> getAllCourses() throws ForoAluraHubExceptions {
        return courseService.getAllCourseByname();
    }

    @GetMapping("/{courseId}")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(responseCode = "200", description = "Course retrieved successfully")
    public CourseDto getCourseById(@PathVariable Integer courseId) {

        return courseService.getCourseById(courseId);
    }

    @GetMapping("/{categoryName}/category")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(responseCode = "200", description = "Courses by category retrieved successfully")
    public List<CourseDto> getCoursesByCategory(@PathVariable String categoryName) {
        return courseService.getCourseByCategory(categoryName);
    }

    @GetMapping("/name")
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(responseCode = "200", description = "Courses by name retrieved successfully")
    public CourseDto getCourseByName(@RequestParam String courseName) throws ForoAluraHubExceptions {
        return courseService.getCourseByCourseName(courseName);
    }

    @PutMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(responseCode = "200", description = "Course Updated successfully")
    public CourseDto updateCourse(@Validated @RequestBody CourseDto courseDto, @RequestParam String courseName) {
        return courseService.modifyCourse(courseName, courseDto);
    }

    @DeleteMapping()
    @ResponseStatus(HttpStatus.OK)
    @ApiResponse(responseCode = "200", description = "Course deleted successfully")
    public GeneralResponse deleteCourse(@RequestParam String courseName) {
        return courseService.removeCourse(courseName);
    }


}
