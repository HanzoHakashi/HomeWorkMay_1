package edu.attractor.homeworkMay_1.homeworkMay_1.dtos;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;

@Builder
@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String address;
    private String username;
}
