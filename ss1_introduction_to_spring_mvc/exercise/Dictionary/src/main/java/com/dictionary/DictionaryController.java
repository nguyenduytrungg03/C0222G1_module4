package com.dictionary;

import com.service.DictionaryService;
import com.service.IDictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class DictionaryController {
    private IDictionaryService iDictionaryService = new DictionaryService();
    @GetMapping("")
    public String home(){
        return "index";
    }
    @PostMapping("/change")
    public String change(@RequestParam String name, Model model) {
        model.addAttribute("result", iDictionaryService.change(name));
        model.addAttribute("name", name);
        return "index";
    }
}
