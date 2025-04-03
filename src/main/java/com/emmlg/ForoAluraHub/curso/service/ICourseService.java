package com.emmlg.ForoAluraHub.curso.service;

import com.emmlg.ForoAluraHub.curso.dto.CourseDto;
import com.emmlg.ForoAluraHub.util.GeneralRespose;

import java.util.List;

public interface ICourseService {

    public CourseDto addCourse(CourseDto courseDto);

    List<CourseDto> addCourse(List<CourseDto> coursesDto);

    public CourseDto getCourseByCourseName(String courseName);

    public List<CourseDto> getCourseByCategory(String categoryName);

    public CourseDto getCourseById(Integer courseId);

    public List<CourseDto> getAllCourseByname();

    public CourseDto modifyCourse(String courseName, CourseDto courseDto);

    public GeneralRespose removeCourse(String courseName);
}
