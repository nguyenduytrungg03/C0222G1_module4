package com.repository;

import com.model.Music;

import java.util.List;

public interface IMusicRepository {
    List<Music> findAll();

    void save(Music music);

    Music findById(int id);

    List<Music> searchByName(String name);

    void update(Music music);

    void remove(int id);
}
