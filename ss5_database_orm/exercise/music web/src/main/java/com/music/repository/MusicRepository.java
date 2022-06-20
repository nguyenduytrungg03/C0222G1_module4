package com.music.repository;

import com.music.model.Music;

import java.util.List;

public interface MusicRepository {
    List<Music> findAll();

    void save(Music music);

    Music findById(String id);

    List<Music> searchByName(String name);

    void update(Music music);

    void remove(String id);
}
