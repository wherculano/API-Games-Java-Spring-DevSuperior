package com.minicurso.devsuperior.dslist.dto;

import com.minicurso.devsuperior.dslist.entities.GameList;

public class GameListDTO {
    private Long id;
    private String name;

    public GameListDTO() {}

    public GameListDTO(GameList entity) {
        this.id = entity.getId();
        this.name = entity.getName();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }
}
