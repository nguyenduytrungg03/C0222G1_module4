package com.blog.blog_levelup.controller;


import com.blog.blog_levelup.model.Blog;
import com.blog.blog_levelup.model.Category;
import com.blog.blog_levelup.service.IBlogService;
import com.blog.blog_levelup.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class BlogController {
    @Autowired
    private IBlogService iBlogService;
    @Autowired
    private ICategoryService iCategoryService;

//    @RequestMapping("/")
//    public String home(Model model) {
//        model.addAttribute("listBlog", iBlogService.findAll());
//        return "list";
//    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        iBlogService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("blog", new Blog());
        model.addAttribute("listCategory", iCategoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String save(Blog blog) {
        iBlogService.save(blog);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String goFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        List<Category> categoryList =iBlogService.categoryList();
        model.addAttribute("categoryList", categoryList);
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(Blog blog) {
        iBlogService.update(blog);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        model.addAttribute("blog", iBlogService.findById(id));
        return "/view";
    }


    @GetMapping(value = "/")
    public String getAllStudent(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
//        Sort sort = Sort.by("point").ascending().and(Sort.by("name_student"));
        Page<Blog> list = iBlogService.getAll(PageRequest.of(page,2));
        model.addAttribute("listBlog", list);
        return "list";
    }

    @PostMapping("/search")
    public String getAllStudent(@RequestParam("name") String name,@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
//        Sort sort = Sort.by("point").ascending().and(Sort.by("name_student"));
        Page<Blog> list = iBlogService.searchByName(name,PageRequest.of(page,2));
        model.addAttribute("listBlog", list);
        return "list";
    }
}
