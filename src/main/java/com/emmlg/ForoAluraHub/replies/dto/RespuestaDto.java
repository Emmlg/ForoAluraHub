package com.emmlg.ForoAluraHub.replies.dto;

import lombok.Data;

import java.time.LocalDate;

@Data
public class RespuestaDto {


    // datos del que respondio
    private long id_usuario;
    private String username; // si pasa el username buscamos el id para guardarlo en db
    // info de respuesta
    private String message;
    private LocalDate fechCreacion;
    private boolean isSolution;

    // datos del tema
    private long id_topico;

}
