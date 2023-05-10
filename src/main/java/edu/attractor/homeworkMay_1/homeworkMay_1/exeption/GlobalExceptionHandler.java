package edu.attractor.homeworkMay_1.homeworkMay_1.exeption;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.UserDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<String> handleUserNotFoundException(UserNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(value = {InvalidRequestException.class})
    public ResponseEntity<UserDto> handleInvalidRequestException(InvalidRequestException e) {
        return ResponseEntity.badRequest().body(null);
    }
}

