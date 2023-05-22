package com.minicurso.devsuperior.dslist.controllers;

import com.minicurso.devsuperior.dslist.dto.GameDTO;
import com.minicurso.devsuperior.dslist.dto.GameMinDTO;
import com.minicurso.devsuperior.dslist.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/games")
public class GameController {
    @Autowired
    private GameService gameService;

    @GetMapping
    public List<GameMinDTO> findAllGames(){
        List<GameMinDTO> result = gameService.findAllGames();
        return result;
    }

    @GetMapping(value = "/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = gameService.findById(id);
        return result;
    }

}
