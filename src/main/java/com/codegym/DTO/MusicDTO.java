package com.codegym.DTO;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;



public class MusicDTO {
    private Long id;

    @NotBlank
    @Size(min = 1, max = 800)
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    private String name;

    @NotBlank
    @Size(min = 1, max = 500)
    @Pattern(regexp = "^[a-zA-Z0-9 ]+$")
    private String singer;

    @NotBlank
    @Size(min = 1, max = 1000)
    @Pattern(regexp = "^[a-zA-Z0-9, ]+$")
    private String category;

    public MusicDTO() {
    }

    public MusicDTO(Long id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public @NotBlank @Size(min = 1, max = 800) @Pattern(regexp = "^[a-zA-Z0-9 ]+$") String getName() {
        return name;
    }

    public void setName(@NotBlank @Size(min = 1, max = 800) @Pattern(regexp = "^[a-zA-Z0-9 ]+$") String name) {
        this.name = name;
    }

    public @NotBlank @Size(min = 1, max = 500) @Pattern(regexp = "^[a-zA-Z0-9 ]+$") String getSinger() {
        return singer;
    }

    public void setSinger(@NotBlank @Size(min = 1, max = 500) @Pattern(regexp = "^[a-zA-Z0-9 ]+$") String singer) {
        this.singer = singer;
    }

    public @NotBlank @Size(min = 1, max = 1000) @Pattern(regexp = "^[a-zA-Z0-9, ]+$") String getCategory() {
        return category;
    }

    public void setCategory(@NotBlank @Size(min = 1, max = 1000) @Pattern(regexp = "^[a-zA-Z0-9, ]+$") String category) {
        this.category = category;
    }
}
