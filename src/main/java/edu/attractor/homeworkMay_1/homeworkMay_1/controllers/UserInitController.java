package edu.attractor.homeworkMay_1.homeworkMay_1.controllers;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.UserDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class UserInitController {

    private final UserService userService;

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }
    @GetMapping("/login")
    public String showLoginPage() {
        return "login";
    }
    @GetMapping("/profile")
    public String loginSuccess() {
        return "profile";
    }
    @PostMapping(path = "/register")
    public String registerPost(UserDto userDto){
        userService.createUser(userDto);
        return "redirect:/login";
}
}
