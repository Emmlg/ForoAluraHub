package com.emmlg.ForoAluraHub.Exceptions;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class ForoAluraHubExceptions extends RuntimeException {

    private List<String> errors;
    private String process;
    private HttpStatus httpStatus;

    public ForoAluraHubExceptions(HttpStatus httpStatus, List<String> errors, String message, String process) {
        super(message);
        this.httpStatus = httpStatus;
        this.errors = errors;
        this.process = process;

    }
}
