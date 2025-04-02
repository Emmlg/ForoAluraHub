package com.emmlg.ForoAluraHub.Exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class ErrorResponse implements Serializable {

    @Schema(description = "Listado de errores")
    private List<String> errors;

    @Schema(description = "Mensaje de error")
    private String message;

    @Schema(description = "Proceso")
    private String process;

    @Schema(description = "HTTP Status")
    private HttpStatus httpStatus;
}
