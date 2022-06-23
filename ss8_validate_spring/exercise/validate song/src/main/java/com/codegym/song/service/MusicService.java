package com.codegym.song.service;

import com.codegym.song.model.Music;
import com.codegym.song.repository.IMusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository iMusicRepository;

    @Override
    public List<Music> findAll() {
        return iMusicRepository.findAll();
    }

    @Override
    public Page<Music> getAll(Pageable pageable) {
        return iMusicRepository.findAllMusic(pageable);
    }

    @Override
    public void save(Music music) {
        iMusicRepository.save(music);
    }

    @Override
    public void update(Music music) {
        iMusicRepository.update(music.getCategory(), music.getNameMusic(), music.getNameSinger(), music.getIdMusic());
    }

    @Override
    public Object findById(int id) {
        return iMusicRepository.findById(id);
    }
}
