package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserService;


@Controller
@RequestMapping("/")
public class UserController {

    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('users:read')")   // это пока не работает
    public String getAllUser(Model model){
        model.addAttribute("users", userService.getAllUser());
        return "user-list";
    }

    @GetMapping("/user-create")
    @PreAuthorize("hasAuthority('users:write')")
    public String createUser(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "user-create";
    }

    @PostMapping("/user-create")
    public String createUser(User user){
        userService.addUser(user);
        return "redirect:/user";
    }

    @GetMapping("/user-delete/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public String deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return "redirect:/user";
    }

    @GetMapping("/user-update/{id}")
    @PreAuthorize("hasAuthority('users:write')")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        model.addAttribute("user", userService.getUserById(id));
        return "user-update";
    }

    @PostMapping("/user-update")
    public String updateUser(User user){
        userService.updateUser(user);
        return "redirect:/user";
    }

}
