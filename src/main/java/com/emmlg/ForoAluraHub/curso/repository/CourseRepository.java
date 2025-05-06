package com.emmlg.ForoAluraHub.curso.repository;

import com.emmlg.ForoAluraHub.curso.modelo.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


public interface CourseRepository extends JpaRepository<Course, Long> {


    boolean existsByCourseNameIgnoreCase(String courseName);

    List<Course> findByCategory_CategoryNameContainingIgnoreCase(String categoryName);

    Course findByCourseId(Integer courseId);

    Course getCourseByCourseName(String courseName);

    boolean existsByCourseId(Integer courseId);

    Course findByCourseName(String courseName);

    void deleteByCourseName(String courseName);
}
