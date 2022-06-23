package com.codegym.song.controller;

import com.codegym.song.model.Music;
import com.codegym.song.service.IMusicService;
import com.codegym.song.service.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    private IMusicService iMusicService;

    @GetMapping(value = "/")
    public String getAllStudent(@RequestParam(name = "page", defaultValue = "0") int page, Model model) {
        Page<Music> list = iMusicService.getAll(PageRequest.of(page,2));
        model.addAttribute("musicList", list);
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String addNew(@Valid Music music, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("musicList", iMusicService.findAll());
            return "create";
        }
        iMusicService.save(music);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String goFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("music", iMusicService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String updateMusic(@Valid Music music,BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "/edit";
        }
        iMusicService.update(music);
        return "redirect:/";
    }

}
