package com.electronic_mail.controller;

import com.electronic_mail.model.ElectronicMail;
import com.electronic_mail.service.IElectronicMailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ElectronicController {
    @Autowired
    IElectronicMailService iElectronicMailService;

    @GetMapping("")
    public String home(Model model) {
        model.addAttribute("electronicMail", new ElectronicMail());
        model.addAttribute("listLanguage", iElectronicMailService.language());
        model.addAttribute("listPageSize", iElectronicMailService.pageSize());
        return "index";
    }

    @PostMapping("/electronicMail")
    public String result(@ModelAttribute("electronicMail") ElectronicMail electronicMail, Model model) {
        model.addAttribute("electronicMail", electronicMail);
        return "result";
    }


}
