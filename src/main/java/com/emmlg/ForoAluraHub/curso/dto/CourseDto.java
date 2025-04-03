package com.emmlg.ForoAluraHub.curso.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;

@Builder
@Getter
@Setter
@AllArgsConstructor
public class CourseDto implements Serializable {

    @Schema(description = "Course Identifier")
    private Integer courseId;

    @Schema(description = "Course Name")
    @NotBlank
    private String courseName;

    @Schema(description = "Course Category")
    @Pattern(regexp = "^[A-Z\s0-9]+$", message = "Category name must be in uppercase letters only")
    @NotBlank
    private String category;

}
