package com.minicurso.devsuperior.dslist.services;

import com.minicurso.devsuperior.dslist.dto.GameDTO;
import com.minicurso.devsuperior.dslist.dto.GameMinDTO;
import com.minicurso.devsuperior.dslist.entities.Game;
import com.minicurso.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;
    @Transactional(readOnly = true)
    public List<GameMinDTO> findAllGames(){
        List<Game> result = gameRepository.findAll();
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }

    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = gameRepository.findById(id).get();
        return new GameDTO(result);

    }
}
