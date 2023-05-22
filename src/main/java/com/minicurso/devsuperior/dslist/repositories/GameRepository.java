package com.minicurso.devsuperior.dslist.repositories;

import com.minicurso.devsuperior.dslist.entities.Game;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GameRepository extends JpaRepository<Game, Long> {
}
