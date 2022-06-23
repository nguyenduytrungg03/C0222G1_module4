package com.codegym.song.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity(name = "music")
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_music")
    private int idMusic;
    @Column(name = "name_music")
    @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "ERROR FORMAT")
    @Size(min = 1, max = 800, message = "không được nhập quá 800 kí tự")
    private String nameMusic;
    @Column(name = "name_singer")
    @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "ERROR FORMAT")
    @Size(min = 1, max = 300, message = "không được nhập quá 300 kí tự")
    private String nameSinger;
    @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "ERROR FORMAT")
    @Size(min = 1, max = 1000, message = "không được nhập quá 1000 kí tự")
    private String category;

    public Music() {
    }

    public Music(int idMusic, @Pattern(regexp = "^[A-Za-z-0-9 ]*$",
            message = "Sai định dạng và không được để trống") @Size(min = 1, max = 800, message = "không được nhập quá 800 kí tự") String nameMusic, @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "Sai định dạng và không được để trống") @Size(min = 1, max = 300, message = "không được nhập quá 300 kí tự") String nameSinger, @Pattern(regexp = "^[A-Za-z-0-9 ]*$", message = "Sai định dạng và không được để trống") @Size(min = 1, max = 1000, message = "không được nhập quá 1000 kí tự") String category) {
        this.idMusic = idMusic;
        this.nameMusic = nameMusic;
        this.nameSinger = nameSinger;
        this.category = category;
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

}
