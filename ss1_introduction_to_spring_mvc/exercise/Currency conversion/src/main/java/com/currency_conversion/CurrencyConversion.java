package com.currency_conversion;

import com.service.CurrencyService;
import com.service.ICurrencyService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CurrencyConversion {
    private ICurrencyService iCurrencyService = new CurrencyService();

    @GetMapping("")
    public String home() {
        return "index";
    }


    @PostMapping("/currency")
    public String conver(@RequestParam double usd, Model model) {
        model.addAttribute("result", iCurrencyService.usdToVnd(usd));
        model.addAttribute("usd", usd);
        return "index";
    }
}
