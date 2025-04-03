package com.emmlg.ForoAluraHub.curso.repository;

import com.emmlg.ForoAluraHub.curso.modelo.CourseCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<CourseCategory, Long> {

    CourseCategory findByCategoryName(String categoryName);

    boolean existsByCategoryName(String categoryName);

}
