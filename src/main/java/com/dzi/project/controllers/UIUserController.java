package com.dzi.project.controllers;

import com.dzi.project.models.User;
import com.dzi.project.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;

@Controller
@RequestMapping(value = "/")
public class UIUserController {
    @Autowired
    private UserService userService;

    @GetMapping("users/create-user")
    public String createUser(Model model) {
        model.addAttribute("user",new User());
        return "admin/create-user";
    }

    @PostMapping(path = "/users", consumes = {MediaType.APPLICATION_FORM_URLENCODED_VALUE})
    public RedirectView submitUser(User user) {
        if (userService.isUsernameAvailable(user.getUsername())) {
            userService.createUser(user);
            return new RedirectView("/users");
        } else {
            return new RedirectView("users?error=username_exists");
        }
    }

    @GetMapping(value = "/users/edit-user/{id}")
    public String editUser(@PathVariable int id, Model model) {
        User editUser = userService.getUser(id);
        model.addAttribute("user", editUser);
        return "admin/edit-user";
    }
    @PostMapping(value = "/users/edit-user")
    public RedirectView editSubmitUser(@ModelAttribute(value = "user") User user) {
        userService.editUser(user);
        return new RedirectView("/users");
    }
    @GetMapping(value = "users")
    public String usersView(Model model){
        List<User> users = userService.getUsers();
        model.addAttribute("users", users);
        return "admin/users";
    }
    @GetMapping(value = "/profile")
    public String profile(Model model, Authentication authentication) {
        User currentUser = (User) authentication.getPrincipal();
        model.addAttribute("user", userService.getUser(currentUser.getId()));
        return "profile";
    }

    @GetMapping(value = "/about")
    public String showAboutPage() {
        return "about";
    }

    @GetMapping(value = "/contact")
    public String showContactPage() {
        return "contact";
    }
}

