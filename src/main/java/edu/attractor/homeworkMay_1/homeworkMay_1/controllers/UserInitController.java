package edu.attractor.homeworkMay_1.homeworkMay_1.controllers;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.UserDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.User;
import edu.attractor.homeworkMay_1.homeworkMay_1.exeption.UserNotFoundException;
import edu.attractor.homeworkMay_1.homeworkMay_1.mappers.UserMapper;
import edu.attractor.homeworkMay_1.homeworkMay_1.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
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
    private final UserMapper userMapper;
    private final MessageSource messageSource;

    @GetMapping("/cart")
    public String testSession() {
        return "cart";
    }

    @GetMapping("/register")
    public String registerGet() {
        return "register";
    }

    @GetMapping("/login")
    public String showLoginPage(@RequestParam(value = "logout", required = false) String logout, Model model) {
        if (logout != null) {
            model.addAttribute("message", messageSource.getMessage("logout.message", null, LocaleContextHolder.getLocale()));
        }
        return "login";
    }

    @GetMapping("/user/forgotPassword")
    public String getProcessForgotPassword() {
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
            String resetPasswordToken = messageSource.getMessage("reset.token.generated.token" , null, LocaleContextHolder.getLocale());
            model.addAttribute("resetPasswordToken", resetPasswordToken + token);
            String resetPasswordMessage = messageSource.getMessage("reset.token.generated.message", null, LocaleContextHolder.getLocale());
            model.addAttribute("message", resetPasswordMessage);
        } catch (UserNotFoundException ex) {
            model.addAttribute("error", ex.getMessage());
        }

        return "forgotPassword";
    }


    @GetMapping("/reset_password")
    public String showResetPasswordPage(Model model) {
        model.addAttribute("title", messageSource.getMessage("reset.password.title", null, LocaleContextHolder.getLocale()));
        model.addAttribute("message", messageSource.getMessage("reset.password.message", null, LocaleContextHolder.getLocale()));
        return "reset_password";
    }

    @PostMapping("/reset_password")
    public String processResetPassword2(HttpServletRequest request, Model model) {
        String token = request.getParameter("token");
        String password = request.getParameter("password");

        User user = userService.getByResetPasswordToken(token);
        model.addAttribute("title", messageSource.getMessage("reset.password.title", null, LocaleContextHolder.getLocale()));

        if (user == null) {
            model.addAttribute("message", messageSource.getMessage("reset.token.invalid", null, LocaleContextHolder.getLocale()));
        } else {
            userService.updatePassword(user, password);
            model.addAttribute("message", messageSource.getMessage("reset.password.changed", null, LocaleContextHolder.getLocale()));
        }

        return "reset_password";
    }

    @GetMapping("/profile")
    public String loginSuccess() {
        return "profile";
    }

    @PostMapping(path = "/register")
    public String registerPost(UserDto userDto) {
        userDto.setActive(true);
        userDto.setRole("USER");
        userService.createUser(userDto);
        return "redirect:/login";
    }
}
