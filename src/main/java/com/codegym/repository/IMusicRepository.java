package com.codegym.repository;

import com.codegym.model.Music;
import org.springframework.data.repository.CrudRepository;

public interface IMusicRepository extends CrudRepository<Music, Long> {

}
