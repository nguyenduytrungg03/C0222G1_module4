package com.sand_wich;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Arrays;

@Controller
public class SandwichController {
    @GetMapping("")
    public String home() {
        return "index";
    }

    @RequestMapping("/sandwich")
    public String save(@RequestParam("condiment") String[] condiment, Model model) {
        model.addAttribute("result", Arrays.toString(condiment));
        return "/result";
    }

}
