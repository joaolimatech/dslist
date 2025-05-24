package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.devsuperior.dslist.entities.GameList;

//O repository é quem executa os comandos tipo SELECT, INSERT, DELETE... mas sem você escrever SQL na mão.
public interface GameListRepository extends JpaRepository<GameList, Long>{ //passa a entity e o id

}
