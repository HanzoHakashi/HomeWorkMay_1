package edu.attractor.homeworkMay_1.homeworkMay_1.exeption;

import org.springframework.web.bind.annotation.ExceptionHandler;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(String id) {
        super("User with id " + id + " not found.");
    }
}
