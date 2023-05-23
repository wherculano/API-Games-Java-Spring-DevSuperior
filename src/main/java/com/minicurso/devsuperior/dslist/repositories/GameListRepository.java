package com.minicurso.devsuperior.dslist.repositories;

import com.minicurso.devsuperior.dslist.entities.GameList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameListRepository extends JpaRepository<GameList, Long> {
}
