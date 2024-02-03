package com.satta.priya.controller;

import com.satta.priya.model.User;
import com.satta.priya.service.userService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class UserController {

    private final userService userservice;

    // Constructor injection
    public UserController(userService userservice) {
        this.userservice = userservice;
    }
    @GetMapping("/")
    public String loginPage(Model model) {
        model.addAttribute("user", new User());
        return "satta/login";
    }
    @PostMapping("/satta")
    public String login(@ModelAttribute("user") User user, Model model) {
        // Fetch user from the database based on the entered username
        User dbUser = userservice.findByUsername(user.getUsername());

        // Check if the entered password matches the one stored in the database
        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            // Successful login
            System.out.println("Logged in");
            return "redirect:/satta/all";
        } else {
            // Failed login, add an error message to the model
            System.out.println("error");
            model.addAttribute("error", "Invalid username or password");
            return "satta/login";
        }
    }
    @GetMapping("/logout")
    public String logout() {
        // Perform logout logic here
        return "redirect:/login/";
    }
}
