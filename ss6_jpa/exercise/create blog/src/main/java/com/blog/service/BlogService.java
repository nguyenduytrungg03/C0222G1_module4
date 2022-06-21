package com.blog.service;

import com.blog.model.Blog;
import com.blog.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    IBlogRepository iBlogRepository;

    @Override
    public List<Blog> findAll() {
        return iBlogRepository.findAllBlog();
    }

    @Override
    public void save(Blog blog) {
        iBlogRepository.save(blog.getNameBlog(), blog.getContent());
    }

    @Override
    public Blog findById(int id) {
        return iBlogRepository.findByIdBlog(id);
    }

    @Override
    public void update(Blog blog) {
        iBlogRepository.updateBlog(blog.getNameBlog(), blog.getContent(), blog.getIdBlog());
    }

    @Override
    public void remove(int id) {
        iBlogRepository.deleteById(id);
    }
}
