package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;


    @GetMapping("/")
    public String home(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Product> list = iProductService.findAll(PageRequest.of(page, 1));
        model.addAttribute("productList", list);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String addNew(@Valid @ModelAttribute("product") Product product,
                         BindingResult bindingResult,
                         Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productList", iProductService.findAll());
            return "create";
        }
        iProductService.save(product);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(@Valid @ModelAttribute("product") Product product,
                       BindingResult bindingResult,
                       Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("productList", iProductService.findAll());
            return "edit";
        }
        iProductService.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") int id) {
        iProductService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "name") String name, @RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Product> list = iProductService.searchByName(name, PageRequest.of(page, 1));
        model.addAttribute("productList", list);
        return "list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }

}