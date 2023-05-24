package edu.attractor.homeworkMay_1.homeworkMay_1.controllers;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.UserDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.User;
import edu.attractor.homeworkMay_1.homeworkMay_1.exeption.UserNotFoundException;
import edu.attractor.homeworkMay_1.homeworkMay_1.mappers.UserMapper;
import edu.attractor.homeworkMay_1.homeworkMay_1.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

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
    @GetMapping("/user/forgotPassword")
    public String getProcessForgotPassword(){
        return "findEmailForPassword";
    }
    @PostMapping("/user/forgotPassword")
    public String processForgotPassword(HttpServletRequest request, Model model) {
        String email = request.getParameter("email");
        Random random = new Random();
        int min = 10000;
        int max = 99999;
        int tokenValue = random.nextInt(max - min + 1) + min;
        String token = String.valueOf(tokenValue);

        try {
            userService.updateResetPasswordToken(token, email);
            String resetPasswordToken = "Token: " + token;
            model.addAttribute("resetPasswordToken", resetPasswordToken);
            model.addAttribute("message", "Token generated successfully. Please use the token to reset your password.");

        } catch (UserNotFoundException ex) {
            model.addAttribute("error", ex.getMessage());
        }

        return "forgotPassword";
    }
    @GetMapping("/reset_password")
    public String showResetPasswordPage(Model model) {
        model.addAttribute("title", "Reset Password");
        model.addAttribute("message", "Wait for a new password");
        return "reset_password";
    }

    @PostMapping("/reset_password")
    public String processResetPassword2(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        User user = userService.getByResetPasswordToken(token);
        model.addAttribute("title", "Reset Password");


        if (user == null) {
            model.addAttribute("message", "Invalid Token");
        } else {
            userService.updatePassword(user, password);
            model.addAttribute("message", "Password changed successfully");
        }

        return "reset_password";
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
