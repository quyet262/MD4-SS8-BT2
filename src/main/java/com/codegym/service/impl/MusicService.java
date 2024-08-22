package com.codegym.service.impl;

import com.codegym.model.Music;
import com.codegym.repository.IMusicRepository;
import com.codegym.service.IMusicService;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MusicService implements IMusicService {
    private final IMusicRepository musicRepository;

    public MusicService(IMusicRepository musicRepository) {
        this.musicRepository = musicRepository;
    }

    @Override
    public Iterable<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public Optional<Music> findById(Long id) {
        return musicRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
    musicRepository.deleteById(id);
    }
}
