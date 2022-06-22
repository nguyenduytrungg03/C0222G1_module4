package com.blog.blog_levelup.repository;


import com.blog.blog_levelup.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    @Query(value = "select * from blog where status_delete <>1", nativeQuery = true)
    List<Blog> findAllBlog();

    @Query(value = "select * from blog where status_delete <>1", nativeQuery = true)
    Page<Blog> findAllBlog(Pageable p);

    @Modifying
    @Query(value = "insert into blog (name_blog,content,status_delete,id) values (:nameblog,:content,0,:idcategory) ", nativeQuery = true)
    void save(@Param("nameblog") String nameblog, @Param("content") String content, @Param("idcategory") int idcategory );

    @Modifying
    @Query(value = "update blog set status_delete =1 where id_blog=:id", nativeQuery = true)
    void deleteById(@Param("id") Integer idBlog);

    @Query(value = "select * from blog where id_blog =:id ", nativeQuery = true)
    Blog findByIdBlog(@Param("id") Integer id);

    @Modifying
    @Query(value = "update blog set name_blog=:nameBlog,content=:content,id=:idcategory where id_blog=:id", nativeQuery = true)
    void updateBlog(@Param("nameBlog") String nameBlog, @Param("content") String content,@Param("idcategory") int idcategory, @Param("id") Integer id);

    @Query(value="select * from blog where name_blog like :blogName and status_delete <> 1 ", nativeQuery = true)
    Page<Blog> searchByName(@Param("blogName") String blogName,Pageable p);

}
