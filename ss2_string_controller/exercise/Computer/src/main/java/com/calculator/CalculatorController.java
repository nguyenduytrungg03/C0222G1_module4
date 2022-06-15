package com.calculator;

import com.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @Autowired
    ICalculatorService iCalculatorService;

    @GetMapping("")
    public String calculator() {
        return "index";
    }

    @PostMapping("/calculator")
    public String total(@RequestParam double number1,
                        @RequestParam double number2,
                        @RequestParam char operator,
                        Model model) {
        model.addAttribute("result", iCalculatorService.calculator(number1, number2, operator));
        model.addAttribute("number1", number1);
        model.addAttribute("number2", number2);
        return "index";
    }

}
