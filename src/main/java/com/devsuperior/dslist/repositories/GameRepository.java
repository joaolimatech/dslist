package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.Game;


//O repository é quem faz os comandos tipo SELECT, INSERT, DELETE... mas sem você escrever SQL na mão.
public interface GameRepository extends JpaRepository<Game, Long>{

}
