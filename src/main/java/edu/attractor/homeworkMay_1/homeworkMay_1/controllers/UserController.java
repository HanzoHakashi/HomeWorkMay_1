package edu.attractor.homeworkMay_1.homeworkMay_1.controllers;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.UserDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.mappers.UserMapper;
import edu.attractor.homeworkMay_1.homeworkMay_1.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;
    private UserMapper userMapper;
    @PostMapping("/searchByEmail/{email}")
    public List<UserDto> searchByEmail(@PathVariable String email){
        return userService.searchUsersByEmail(email).stream().map(p->userMapper.fromUser(p)).collect(Collectors.toList());
    }

    @PostMapping("/searchByUserName/{username}")
    public List<UserDto> searchByUserName(@PathVariable String username){
        return userService.searchUsersByUsername(username).stream().map(p->userMapper.fromUser(p)).collect(Collectors.toList());
    }

    @PostMapping("/searchByName/{name}")
    public List<UserDto> searchByName(@PathVariable String name){
        return userService.searchUsersByName(name).stream().map(p->userMapper.fromUser(p)).collect(Collectors.toList());
    }

    @PostMapping("/existsUser/{email}")
    public boolean existsByEmail(@PathVariable String email){
        return userService.existsByEmail(email);
    }
}
