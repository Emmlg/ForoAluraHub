package com.emmlg.ForoAluraHub.curso.modelo;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private Integer courseId;

    @Column(name = "course_title", unique = true)
    private String courseName;

    // relacion con categorias
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_categoryId")
    private CourseCategory category;


}
