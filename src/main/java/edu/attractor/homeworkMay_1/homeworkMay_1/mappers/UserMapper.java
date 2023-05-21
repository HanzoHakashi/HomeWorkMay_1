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
                .active(user.isActive())
                .role(user.getRole())
                .build();
    }
    public static User fromDto(UserDto userDto){
        return User.builder()
                .firstName(userDto.getFirstName())
                .lastName(userDto.getLastName())
                .email(userDto.getEmail())
                .password(userDto.getPassword())
                .address(userDto.getAddress())
                .username(userDto.getUsername())
                .active(userDto.isActive())
                .role(userDto.getRole()).build();
    }
}
