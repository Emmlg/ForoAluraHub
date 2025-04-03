package com.emmlg.ForoAluraHub.util;

import com.emmlg.ForoAluraHub.curso.dto.CourseCategoryDto;
import com.emmlg.ForoAluraHub.curso.dto.CourseDto;
import com.emmlg.ForoAluraHub.curso.modelo.Course;
import com.emmlg.ForoAluraHub.curso.modelo.CourseCategory;

public class ConvertDtoToEntity {

    public static CourseCategory convertDtoToEntity(CourseCategoryDto courseCategoryDto) {

        if (courseCategoryDto == null) {
            return null;
        }
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setCategoryId(courseCategoryDto.getCategoryId());
        courseCategory.setCategoryName(courseCategoryDto.getCategoryName());
        return courseCategory;
    }

    public static Course convertDtoToEntity(CourseDto courseDto) {
        if (courseDto == null) {
            return null;
        }
        Course course = new Course();
        course.setCourseId(courseDto.getCourseId());
        course.setCourseName(courseDto.getCourseName());
        CourseCategory courseCategory = new CourseCategory();
        courseCategory.setCategoryName(courseDto.getCategory());
        course.setCategory(courseCategory);
        return course;
    }
}
