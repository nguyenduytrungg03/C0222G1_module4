package com.blog.blog_levelup.repository;

import com.blog.blog_levelup.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoryRepository extends JpaRepository<Category, Integer> {
}
