package com.emmlg.ForoAluraHub.curso.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class CursoDto implements Serializable {

    private String courseId;
    private String courseName;
    private String category;
}
