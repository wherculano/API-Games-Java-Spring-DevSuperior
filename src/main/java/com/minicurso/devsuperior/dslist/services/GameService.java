package com.minicurso.devsuperior.dslist.services;

import com.minicurso.devsuperior.dslist.dto.GameMinDTO;
import com.minicurso.devsuperior.dslist.entities.Game;
import com.minicurso.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    public List<GameMinDTO> findAllGames(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
