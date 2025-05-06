package com.emmlg.ForoAluraHub.curso.modelo;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "Courses")
public class Course {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_course")
    private long courseId;

    @Column(name = "course_title")
    private String courseName;

    // relacion con categorias
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "fk_categoryId")
    private CourseCategory category;


}
