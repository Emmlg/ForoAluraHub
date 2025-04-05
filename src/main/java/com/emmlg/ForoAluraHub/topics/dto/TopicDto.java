package com.emmlg.ForoAluraHub.topics.dto;


import com.emmlg.ForoAluraHub.replies.modelo.Reply;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@Builder
public class TopicDto implements Serializable {

    @Schema(description = "ID del topico")
    private Integer topicoId;

    @NotBlank
    @Schema(description = "Titulo del topico")
    private String title;

    @Schema(description = "Mensaje del topico")
    @NotBlank(message = "El mensaje no puede estar vacío")
    @Size(max = 3000, message = "El mensaje no puede exceder los 3000 caracteres")
    private String message;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "Fecha de creacion del topico")
    private LocalDate creationDate;

    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "Fecha de actualizacion del topico")
    private LocalDate updateDate;

    @NotBlank
    @Schema(description = "Estado del topico")
    private String status;

    @NotBlank
    @Schema(description = "Nombre del curso")
    private String CursoName;

    @NotBlank
    @Schema(description = "Categoria del curso")
    private String CursoCategory;

    @Schema(description = "Respuesta del topico")
    private List<Reply> replies;


}
