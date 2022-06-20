package com.music.repository.impl;

import com.music.model.Music;
import com.music.repository.MusicRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MusicRepositoryImpl implements MusicRepository {
    @Override
    public List<Music> findAll() {
        List<Music> musicList =BaseRepository.entityManager.createQuery("select m from music s",Music.class).getResultList();
        return musicList;
    }

    @Override
    public void save(Music music) {

    }

    @Override
    public Music findById(String id) {
        return null;
    }

    @Override
    public List<Music> searchByName(String name) {
        return null;
    }

    @Override
    public void update(Music music) {

    }

    @Override
    public void remove(String id) {

    }
}
