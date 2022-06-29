package com.blog.blog_levelup.service;

import com.blog.blog_levelup.model.Category;
import com.blog.blog_levelup.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService implements ICategoryService {
    @Autowired
    ICategoryRepository iCategoryRepository;

    @Override
    public List<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return iCategoryRepository.findById(id);
    }
}
