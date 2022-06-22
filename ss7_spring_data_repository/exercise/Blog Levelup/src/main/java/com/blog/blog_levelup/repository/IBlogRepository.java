package com.blog.repository;

import com.blog.model.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import javax.transaction.Transactional;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where status_delete <>1", nativeQuery = true)
    List<Blog> findAllBlog();

    @Modifying
    @Query(value = "insert into blog (name_blog,content,status_delete) values (:nameblog,:content,0) ", nativeQuery = true)
    void save(@Param("nameblog") String nameblog, @Param("content") String content);

    @Modifying
    @Query(value = "update blog set status_delete =1 where id_blog=:id", nativeQuery = true)
    void deleteById(@Param("id") Integer idBlog);

    @Query(value = "select * from blog where id_blog =:id ", nativeQuery = true)
    Blog findByIdBlog(@Param("id") Integer id);

    @Modifying
    @Query(value = "update blog set name_blog=:nameBlog,content=:content where id_blog=:id", nativeQuery = true)
    void updateBlog(@Param("nameBlog") String nameBlog, @Param("content") String content, @Param("id") Integer id);
}
