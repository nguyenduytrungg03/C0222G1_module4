package com.model;

import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_music", columnDefinition = "int")
    private int idMusic;
    @Column(name = "name_music")
    private String nameMusic;
    @Column(name = "name_singer")
    private String nameSinger;
    private String category;
    private String url;
    @ColumnDefault("0")
    private int statusDelete;

    public Music() {
    }

    public Music(int idMusic, String nameMusic, String nameSinger, String category, String url) {
        this.idMusic = idMusic;
        this.nameMusic = nameMusic;
        this.nameSinger = nameSinger;
        this.category = category;
        this.url = url;
    }

    public Music(int idMusic, String nameMusic, String nameSinger, String category, String url, int statusDelete) {
        this.idMusic = idMusic;
        this.nameMusic = nameMusic;
        this.nameSinger = nameSinger;
        this.category = category;
        this.url = url;
        this.statusDelete = statusDelete;
    }

    public int getStatusDelete() {
        return statusDelete;
    }

    public void setStatusDelete(int statusDelete) {
        this.statusDelete = statusDelete;
    }

    public int getIdMusic() {
        return idMusic;
    }

    public void setIdMusic(int idMusic) {
        this.idMusic = idMusic;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getNameSinger() {
        return nameSinger;
    }

    public void setNameSinger(String nameSinger) {
        this.nameSinger = nameSinger;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
