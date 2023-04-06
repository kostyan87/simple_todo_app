package com.ignatev.simple_todo_app_v1.exception;

import com.ignatev.simple_todo_app_v1.payload.ExceptionMessageResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<ExceptionMessageResponse> handleUserExistException(
            UserExistException userExistException
    ) {
        ExceptionMessageResponse exceptionMessageResponse =
                new ExceptionMessageResponse(userExistException.getMessage());

        return new ResponseEntity<ExceptionMessageResponse>(exceptionMessageResponse,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessageResponse> handleUsernameNotFoundException(
            UsernameNotFoundException usernameNotFoundException
    ) {
        ExceptionMessageResponse exceptionMessageResponse =
                new ExceptionMessageResponse(usernameNotFoundException.getMessage());

        return new ResponseEntity<ExceptionMessageResponse>(exceptionMessageResponse,
                HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<ExceptionMessageResponse> handleTaskNotFoundException(
            TaskNotFoundException taskNotFoundException
    ) {
        ExceptionMessageResponse exceptionMessageResponse =
                new ExceptionMessageResponse(taskNotFoundException.getMessage());

        return new ResponseEntity<ExceptionMessageResponse>(exceptionMessageResponse,
                HttpStatus.BAD_REQUEST);
    }
}
