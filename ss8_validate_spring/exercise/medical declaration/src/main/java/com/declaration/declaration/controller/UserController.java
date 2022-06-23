package com.declaration.declaration.controller;

import com.declaration.declaration.model.User;
import com.declaration.declaration.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/create")
    public String displayIndex(Model model) {
        model.addAttribute("user", new User());
        return "/create";
    }

    @PostMapping("/save")
    public String result(@Valid User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "/create";
        } else {
            userService.save(user);
            model.addAttribute("msg", "Thêm mới thành công");
            return "/list";
        }
    }
}
