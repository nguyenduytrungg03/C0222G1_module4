package com.controller;

import com.model.Music;
import com.service.IMusicService;
import org.jboss.logging.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @RequestMapping("/")
    public String home(Model model) {
        model.addAttribute("musicList", musicService.findAll());
        return "list";
    }

    @GetMapping("/create")
    public String create(Model model) {
        model.addAttribute("music", new Music());
        return "create";
    }

    @PostMapping("/save")
    public String save(Music music) {
        musicService.save(music);
        return "redirect:/";
    }

    @GetMapping("/search")
    public String searchByName(String name, Model model) {
        model.addAttribute("musicList", musicService.searchByName(name));
        return "list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") int id) {
        musicService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String goFormEdit(@PathVariable int id, Model model) {
        model.addAttribute("music", musicService.findById(id));
        return "/edit";
    }

    @PostMapping("/edit")
    public String edit(Music music) {
        musicService.update(music);
        return "redirect:/";
    }

}
