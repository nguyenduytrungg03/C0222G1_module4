package com.blog.blog_levelup.service;

import com.blog.blog_levelup.model.Category;

import java.util.List;
import java.util.Optional;

public interface ICategoryService {
    List<Category> findAll();

    Optional<Category> findById(int id);
}
