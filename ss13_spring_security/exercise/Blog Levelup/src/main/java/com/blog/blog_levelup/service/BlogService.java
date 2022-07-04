package com.blog.blog_levelup.service;


import com.blog.blog_levelup.model.Blog;

import com.blog.blog_levelup.model.Category;
import com.blog.blog_levelup.repository.IBlogRepository;
import com.blog.blog_levelup.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAll();
    }

    @Override
    public Page<Blog> getAll(Pageable pageable) {
        return iBlogRepository.findAllBlog(pageable);
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog.getNameBlog(), blog.getContent(),blog.getCategory().getIdCategory());
    }

    @Override
    public Optional findById(int id) {
        return iBlogRepository.findById(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.updateBlog(blog.getNameBlog(), blog.getContent(),blog.getCategory().getIdCategory(), blog.getIdBlog());
    }

    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }

    @Override
    public Page<Blog> searchByName(String nameBlog, Pageable p ) {
        return iBlogRepository.searchByName("%"+ nameBlog + "%",p);
    }

    public List<Category> categoryList(){
       return iCategoryRepository.findAll();
    }
}
