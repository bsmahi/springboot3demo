package com.bsmlabs.springboot3demo.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProblemDetailErrorHandling {

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ProblemDetail onException(HttpServletRequest request) {
        request.getAttributeNames().asIterator()
                .forEachRemaining(attributeName -> System.out.println("attributeName" + attributeName));

        return ProblemDetail
                .forStatusAndDetail(HttpStatusCode.valueOf(404), "the name is invalid");
    }
}
