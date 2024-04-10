package com.dzi.project.controllers;

import com.dzi.project.dto.LogInDTO;

import com.dzi.project.models.User;
import com.dzi.project.services.LogInService;
import com.dzi.project.services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
@CrossOrigin
public class UIAuthenticationController {
    @Autowired
    private final LogInService logInService;
    private final UserService userService;

    public UIAuthenticationController(LogInService logInService, UserService userService) {
        this.logInService = logInService;
        this.userService = userService;
    }

    @GetMapping(value = "/login")
    public String showLoginPage(Model model) {
        model.addAttribute("logInInfo", new LogInDTO());
        return "form/login";
    }

    @PostMapping(value = "/login")
    public String loginUser(@ModelAttribute LogInDTO logInDTO) {
        boolean isLogged = logInService.logIn(logInDTO.getUsername(), logInDTO.getPassword());
        if (isLogged) {
            return "index";
        } else {
            return "form/login";
        }
    }

    @GetMapping(value = "/register")
    public String registerUser(Model model) {
        model.addAttribute("user",new User());
        return "form/register";
    }

    @PostMapping(path = "/register", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public RedirectView submitUser(User user) {
        if (userService.isUsernameAvailable(user.getUsername())) {
            userService.createUser(user);
            return new RedirectView("/");
        } else {
            return new RedirectView("/register?error=username_exists");
        }
    }

}
