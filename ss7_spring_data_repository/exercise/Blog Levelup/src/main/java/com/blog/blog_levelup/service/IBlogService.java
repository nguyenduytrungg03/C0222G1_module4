package com.blog.blog_levelup.service;


import com.blog.blog_levelup.model.Blog;
import com.blog.blog_levelup.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    List<Blog> findAll();

    Page<Blog> getAll(Pageable pageable);

    List<Category> categoryList();

    void save(Blog blog);

    Object findById(int id);

    void update(Blog blog);

    void remove(int id);

    Page<Blog> searchByName(String nameBlog,Pageable p);
}
