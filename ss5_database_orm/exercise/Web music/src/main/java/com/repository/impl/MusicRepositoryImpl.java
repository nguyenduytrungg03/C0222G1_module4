package com.repository.impl;

import com.model.Music;
import com.repository.IMusicRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityTransaction;
import java.util.List;

@Repository
public class MusicRepositoryImpl implements IMusicRepository {
    @Override
    public List<Music> findAll() {
        List<Music> musicList = BaseRepository.entityManager.createQuery("select m from music m where m.statusDelete <> 1", Music.class).getResultList();
        return musicList;
    }

    @Override
    public void save(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.persist(music);
        entityTransaction.commit();
    }

    @Override
    public Music findById(int id) {
        Music music = BaseRepository.entityManager.createQuery("select m from music m where m.id = ?1", Music.class).setParameter(1, id).getSingleResult();
        return music;
    }

    @Override
    public List<Music> searchByName(String name) {
        return BaseRepository.entityManager.createQuery("select m from music m where m.nameMusic like ?1", Music.class).setParameter(1, "%" + name + "%").getResultList();
    }

    @Override
    public void update(Music music) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }

    @Override
    public void remove(int id) {
        EntityTransaction entityTransaction = BaseRepository.entityManager.getTransaction();
        entityTransaction.begin();
        ;
        Music music = findById(id);
        music.setStatusDelete(1);
        BaseRepository.entityManager.merge(music);
        entityTransaction.commit();
    }
}
