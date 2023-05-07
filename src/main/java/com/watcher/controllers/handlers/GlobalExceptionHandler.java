package com.watcher.controllers.handlers;

import com.watcher.exceptions.ExceptionResponse;
import com.watcher.exceptions.NoSuchSymbolException;
import com.watcher.exceptions.NonUniqueUsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NonUniqueUsernameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse catchNonUniqueUsernameException(NonUniqueUsernameException exception) {
        return new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
    }


    @ExceptionHandler(NoSuchSymbolException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ExceptionResponse catchNoSuchSymbolException(NoSuchSymbolException exception) {
        return new ExceptionResponse(exception.getMessage(), LocalDateTime.now());
    }
}