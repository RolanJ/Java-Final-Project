package com.example.javafinalproject.Exceptions;

import lombok.extern.slf4j.Slf4j;
import com.example.javafinalproject.DTOs.JumagulovRolanErrorDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.ErrorResponse;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public JumagulovRolanErrorDTO handleNotFound(ResourceNotFoundException ex) {
        log.error("Thing not found" + ex);
        return new JumagulovRolanErrorDTO(
            HttpStatus.NOT_FOUND.value(),
            "Thing not found" + ex.getMessage(),
            System.currentTimeMillis()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public JumagulovRolanErrorDTO handleGlobal(Exception ex) {
        log.error("Internal Error" + ex);
        return new JumagulovRolanErrorDTO(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Error occured" + ex.getMessage(),
                System.currentTimeMillis()
        );
    }


}

