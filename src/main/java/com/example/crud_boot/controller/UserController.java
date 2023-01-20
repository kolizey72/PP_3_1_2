package com.example.crud_boot.controller;

import com.example.crud_boot.model.User;
import com.example.crud_boot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String users(Model model) {
        model.addAttribute("users", userService.findAll());
        return "index";
    }

    @GetMapping("/new")
    public String createUserPage(@ModelAttribute("user") User user) {
        return "new";
    }

    @PostMapping("/new")
    public String createUser(@ModelAttribute User user) {
        userService.add(user);
        return "redirect:/users";
    }

    @GetMapping("/edit/{id}")
    public String editUserPage(Model model, @PathVariable long id) {
        model.addAttribute("user", userService.findById(id));
        return "edit";
    }

    @PostMapping("/edit/{id}")
    public String editUser(@ModelAttribute("user") User updatedUser, @PathVariable long id) {
        userService.update(id, updatedUser);
        return "redirect:/users";
    }

    @PostMapping("/delete/{id}")
    public String deleteUser(@PathVariable long id) {
        userService.delete(id);
        return "redirect:/users";
    }
}
