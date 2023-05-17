package edu.attractor.homeworkMay_1.homeworkMay_1.dtos;


import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Builder
@Data
public class UserDto {
    private Long id;
    @NotNull
    @Size(min = 3, max = 30)
    private String firstName;
    @NotNull
    @Size(min = 3, max = 30)
    private String lastName;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 8, max = 30)
    private String password;
    private String address;
    private String username;
    @Builder.Default
    private boolean active = true;
    @Builder.Default
    private String role = "USER";
}
