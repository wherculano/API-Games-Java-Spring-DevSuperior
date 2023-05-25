package com.minicurso.devsuperior.dslist.services;

import com.minicurso.devsuperior.dslist.dto.GameListDTO;
import com.minicurso.devsuperior.dslist.entities.GameList;
import com.minicurso.devsuperior.dslist.projections.GameMinProjection;
import com.minicurso.devsuperior.dslist.repositories.GameListRepository;
import com.minicurso.devsuperior.dslist.repositories.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class GameListService {
    @Autowired
    private GameListRepository gameListRepository;

    @Autowired
    private GameRepository gameRepository;

    @Transactional(readOnly = true)
    public List<GameListDTO> findAll() {
        List<GameList> result = gameListRepository.findAll();
        return result.stream().map(x -> new GameListDTO(x)).toList();
    }

    @Transactional
    public void move(Long listId, int sourceIndex, int destinationId) {
        List<GameMinProjection> list = gameRepository.searchByList(listId);
        GameMinProjection obj = list.remove(sourceIndex);
        list.add(destinationId, obj);

        int min = Math.min(sourceIndex, destinationId);
        int max = Math.max(sourceIndex, destinationId);

        for (int i = min; i <= max; i++) {
            gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
        }
    }
}
