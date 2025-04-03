package com.emmlg.ForoAluraHub.curso.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "course_categories")
public class CourseCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_category")
    private Integer categoryId;

    @Column(name = "category_name", unique = true)
    private String categoryName;
}
