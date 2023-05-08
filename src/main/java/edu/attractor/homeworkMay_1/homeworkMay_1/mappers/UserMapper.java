package edu.attractor.homeworkMay_1.homeworkMay_1.mappers;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.UserDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public static UserDto fromUser(User user){
        return UserDto.builder()
                .firstName(user.getFirstName())
                .lastName(user.getLastName())
                .email(user.getEmail())
                .password(user.getPassword())
                .address(user.getAddress())
                .username(user.getUsername())
                .build();
    }
}
