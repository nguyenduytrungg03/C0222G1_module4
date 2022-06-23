package com.codegym.song.service;

import com.codegym.song.model.Music;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IMusicService {

    List<Music> findAll();

    Page<Music> getAll(Pageable pageable);

    void save(Music music);

    void update(Music music);

    Object findById(int id);
}