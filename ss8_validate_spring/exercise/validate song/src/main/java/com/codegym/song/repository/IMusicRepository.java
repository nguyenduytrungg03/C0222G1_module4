package com.codegym.song.repository;

import com.codegym.song.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface IMusicRepository extends JpaRepository<Music, Integer> {
    @Query(value = "select * from music ", nativeQuery = true)
    Page<Music> findAllMusic(Pageable pageable);

    @Modifying
    @Query(value = "update music set category = :category, name_music = :nameMusic, name_singer = :nameSinger where id_music = :idMusic", nativeQuery = true)
    void update(@Param("category") String category, @Param("nameMusic") String nameMusic, @Param("nameSinger") String nameSinger, @Param("idMusic") int idMusic);
}
