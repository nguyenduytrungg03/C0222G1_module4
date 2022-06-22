package com.blog.blog_levelup.model;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog")
    private Integer idBlog;
    @Column(name = "name_blog")
    private String nameBlog;
    private String content;
    @Column(name = "status_delete")
    private int statusDelete;
    @ManyToOne
    @JoinColumn(name = "id")
    private Category category;

    public Blog() {
    }

    public Blog(Integer idBlog, String nameBlog, String content, int statusDelete) {
        this.idBlog = idBlog;
        this.nameBlog = nameBlog;
        this.content = content;
        this.statusDelete = statusDelete;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }


}
