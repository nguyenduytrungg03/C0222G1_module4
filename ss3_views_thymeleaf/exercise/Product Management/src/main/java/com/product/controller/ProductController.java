package com.product.controller;

import com.product.model.Product;
import com.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("product",new Product());
        model.addAttribute("listProduct", productService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("Product", new Product());
        return "create";
    }

    @PostMapping("/save")
    public String save(Product product){
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String id) {
         productService.remove(id);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String goFormEdit(@PathVariable String id,  Model model) {
        model.addAttribute("product", productService.findById(id));
        return "/edit";
    }
    @PostMapping("/edit")
    public String edit(Product product){
        productService.update(product);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable String id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "/view";
    }

    @GetMapping("/search")
    public String searchByName(Product product,Model model){
        model.addAttribute("listProduct",productService.searchByName(product.getName()));
        return "list";
    }
}
