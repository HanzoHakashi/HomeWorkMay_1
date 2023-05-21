package edu.attractor.homeworkMay_1.homeworkMay_1.controllers;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.UserDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.mappers.UserMapper;
import edu.attractor.homeworkMay_1.homeworkMay_1.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class UserInitController {

    private final UserService userService;
    private UserMapper userMapper;
    @GetMapping("/cart")
    public String testSession(){
        return "cart";
    }
    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }
    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value = "logout", required = false) String logout, Model model) {
        if (logout != null) {
            model.addAttribute("message", "You have been logged out successfully.");
        }
        return "login";
    }
    @GetMapping("/profile")
    public String loginSuccess() {
        return "profile";
    }
    @PostMapping(path = "/register")
    public String registerPost(UserDto userDto){
        userDto.setActive(true);
        userDto.setRole("USER");
        userService.createUser(userDto);
        return "redirect:/login";
}
}
