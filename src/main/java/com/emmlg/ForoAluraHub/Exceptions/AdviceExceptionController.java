package com.emmlg.ForoAluraHub.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

@RestControllerAdvice
public class AdviceExceptionController {

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorResponse handleGeneralException(Exception e) {
        return ErrorResponse.builder()
                .errors(List.of("An unexpected error occurred", "error not handled"))
                .message(e.getMessage())
                .process("General")
                .httpStatus(HttpStatus.INTERNAL_SERVER_ERROR)
                .build();
    }

    @ExceptionHandler(ForoAluraHubExceptions.class)
    public ResponseEntity<ErrorResponse> handleForoAluraHubExceptions(ForoAluraHubExceptions e) {
        return ResponseEntity.status(e.getHttpStatus()).
                body(
                        ErrorResponse.builder()
                                .errors(e.getErrors())
                                .message(e.getMessage())
                                .process(e.getProcess())
                                .httpStatus(e.getHttpStatus())
                                .build()
                );
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorResponse> handleIllegalArgumentException(IllegalArgumentException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .errors(List.of("Invalid argument provided"))
                        .message(e.getMessage())
                        .process("Validation")
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .build());
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorResponse> handleNullPointerException(NullPointerException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(ErrorResponse.builder()
                        .errors(List.of("Null value encountered"))
                        .message(e.getMessage())
                        .process("Validation")
                        .httpStatus(HttpStatus.BAD_REQUEST)
                        .build());
    }

}
