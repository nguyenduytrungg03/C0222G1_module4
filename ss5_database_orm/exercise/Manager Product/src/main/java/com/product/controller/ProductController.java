package com.product.controller;

import com.product.model.Product;
import com.product.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class ProductController {
    @Autowired
    private IProductService iProductService;


    @GetMapping("/")
    public String home(Model model) {
        List<Product> productList = iProductService.findAll();
        model.addAttribute("productList", productList);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product) {
        iProductService.save(product);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String update(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String edit(Product product) {
        iProductService.update(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String remove(@PathVariable("id") int id) {
        iProductService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchList(@RequestParam("name") String name, Model model) {
        List<Product> products = iProductService.searchByName(name);
        model.addAttribute("productList", products);
        return "list";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable("id") int id, Model model) {
        model.addAttribute("product", iProductService.findById(id));
        return "view";
    }

}