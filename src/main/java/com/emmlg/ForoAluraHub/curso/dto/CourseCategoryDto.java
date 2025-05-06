package com.emmlg.ForoAluraHub.curso.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.*;

import java.io.Serializable;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CourseCategoryDto implements Serializable {

    @Schema(description = "Category Id")
    private Integer categoryId;

    @Schema(description = "Category Name must be in UpperCase")
    @NotBlank
    @Pattern(regexp = "^[A-Z\s0-9]+$", message = "Category name must be in uppercase letters only")
    private String CategoryName;

}
