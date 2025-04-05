package com.emmlg.ForoAluraHub.replies.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.time.LocalDate;

@Data
public class RespuestaDto {


    // datos del que respondio
    private long id_usuario;
    private String username; // si pasa el username buscamos el id para guardarlo en db
    // info de respuesta

    @NotBlank(message = "El mensaje no puede estar vacío")
    @Size(max = 3000, message = "El mensaje no puede exceder los 3000 caracteres")
    private String message;
    private LocalDate fechCreacion;
    private boolean isSolution;
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "Fecha de actualizacion del topico")
    private LocalDate updateDate;
    // datos del tema
    private long id_topico;

}
