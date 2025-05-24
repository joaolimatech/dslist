package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;

//O repository é quem executa os comandos tipo SELECT, INSERT, DELETE... mas sem você escrever SQL na mão.
public interface GameListRepository extends JpaRepository<GameList, Long>{ //passa a entity e o id
	
	}
