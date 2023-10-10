package com.iamlipe.MyMacros.adapter.exceptions;

import com.iamlipe.MyMacros.infrastructure.exceptions.*;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ResourceExceptionHandler {

    @ExceptionHandler(EmailAlreadyRegistered.class)
    public ResponseEntity<StandadError> emailAlreadyRegistred(EmailAlreadyRegistered e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.CONFLICT;
        StandadError error = new StandadError(status.value(), "Email Already Registered", e.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InvalidEmailFormat.class)
    public ResponseEntity<StandadError> invalidEmailFormat(InvalidEmailFormat e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandadError error = new StandadError(status.value(), "Invalid Email Format", e.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InvalidNameLength.class)
    public ResponseEntity<StandadError> invalidNameLength(InvalidNameLength e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandadError error = new StandadError(status.value(), "Invalid Name Length", e.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(InvalidPasswordLength.class)
    public ResponseEntity<StandadError> invalidPasswordLength(InvalidPasswordLength e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandadError error = new StandadError(status.value(), "Invalid Password Length", e.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(IncorrectPassword.class)
    public ResponseEntity<StandadError> incorrectPassword(IncorrectPassword e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandadError error = new StandadError(status.value(), "Incorrect Password", e.getMessage());
        return ResponseEntity.status(status).body(error);
    }

    @ExceptionHandler(NotFound.class)
    public ResponseEntity<StandadError> notFound(NotFound e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.NOT_FOUND;
        StandadError error = new StandadError(status.value(), "NOT FOUND", e.getMessage());
        return ResponseEntity.status(status).body(error);
    }
}
