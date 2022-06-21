package com.declaration.controller;

import com.declaration.model.Declaration;
import com.declaration.service.IDeclarationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DeclarationController {

    @Autowired
    private IDeclarationService iDeclarationService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("declaration", new Declaration());
        model.addAttribute("listNationality", iDeclarationService.nationality());
        model.addAttribute("listDayOfBirth", iDeclarationService.dayOfBirth());
        model.addAttribute("listVehicle", iDeclarationService.vehicle());
        return "index";
    }

    @PostMapping("/declaration")
    public String result(@ModelAttribute("declaration") Declaration declaration, Model model) {
        model.addAttribute("declaration", declaration);
        return "result";
    }
}
