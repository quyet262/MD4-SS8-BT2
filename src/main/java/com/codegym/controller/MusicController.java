package com.codegym.controller;

import com.codegym.DTO.MusicDTO;
import com.codegym.model.Music;
import com.codegym.service.IMusicService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
@RequestMapping("/music")
public class MusicController {
    private final IMusicService musicService;

    public MusicController(IMusicService musicService) {
        this.musicService = musicService;
    }

    @GetMapping("")
    public ModelAndView index() {
        Iterable<Music> musics = musicService.findAll();
        ModelAndView mav = new ModelAndView("/music/index");
        mav.addObject("musics", musics);
        return mav;
    }
    @GetMapping("create")
    public ModelAndView create() {
        ModelAndView mav = new ModelAndView("/music/create");
        mav.addObject("musicDTO", new MusicDTO());
        return mav;
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("musicDTO") MusicDTO musicDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/music/create";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO,music);
        musicService.save(music);
        return "redirect:/music";
    }

    @GetMapping("/update/{id}")
    public ModelAndView edit(@PathVariable Long id) {
        ModelAndView mav = new ModelAndView("/music/update");
        mav.addObject("musicDTO", musicService.findById(id));
        return mav;
    }
    @PostMapping("/update")
    public String update(@Valid @ModelAttribute("musicDTO") MusicDTO musicDTO, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "/music/update";
        }
        Music music = new Music();
        BeanUtils.copyProperties(musicDTO,music);
        musicService.save(music);
        return "redirect:/music";
    }
}
