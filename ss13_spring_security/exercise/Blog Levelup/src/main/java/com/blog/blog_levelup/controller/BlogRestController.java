package com.blog.blog_levelup.controller;

import com.blog.blog_levelup.model.Blog;
import com.blog.blog_levelup.model.Category;
import com.blog.blog_levelup.service.IBlogService;
import com.blog.blog_levelup.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RestController
public class BlogRestController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategoryService iCategoryService;

    @GetMapping("/category")
    public ResponseEntity<Iterable<Category>> findAllCategory() {
        List<Category> categoryList = iCategoryService.findAll();
        if (categoryList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categoryList, HttpStatus.OK);
    }

    @GetMapping("/blog")
    public ResponseEntity<Iterable<Blog>> findAllBlog(){
        List<Blog> blogList = iBlogService.findAll();
        if (blogList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }


    @GetMapping("/category/{id}")
    public ResponseEntity<?> findCategoryById(@PathVariable int id){
        Optional<Category> categoryOptional = iCategoryService.findById(id);
        if (!categoryOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        Set<Blog> blogs = categoryOptional.get().getBlogs();
        return new ResponseEntity<>(blogs, HttpStatus.OK);
    }

    @GetMapping("/blog/{id}")
    public ResponseEntity<Blog> findBlogById(@PathVariable int id){
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (!blogOptional.isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blogOptional.get(),HttpStatus.OK);
    }

    @PostMapping("/blog")
    public ResponseEntity<Blog> saveBlog(@RequestBody Blog blog) {
        iBlogService.save(blog);
        return new ResponseEntity<>(blog, HttpStatus.CREATED);
    }

    @PutMapping("/blog/{id}")
    public ResponseEntity<?> updateCustomer(@PathVariable int id, @RequestBody Blog blog) {
        Optional<Blog> blogOptional = iBlogService.findById(id);
        if (!blogOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blog.setIdBlog(blogOptional.get().getIdBlog());
        iBlogService.save(blog);
        return new ResponseEntity<>(blog,HttpStatus.OK);
    }

    @GetMapping("/blogs/{search}")
    public ResponseEntity<?> searchByName(@PathVariable String search){
        Page<Blog> blogOptional = iBlogService.searchByName(search, PageRequest.of(0,100));
        return new ResponseEntity<>(blogOptional,HttpStatus.OK);
    }

    @GetMapping("/blogs/load/{ascending}")
    public ResponseEntity<?> getAllStudent(@PathVariable int ascending) {
        Page<Blog> blogOptional = iBlogService.getAll(PageRequest.of(0,ascending));
        return new ResponseEntity<>(blogOptional,HttpStatus.OK);
    }
}
