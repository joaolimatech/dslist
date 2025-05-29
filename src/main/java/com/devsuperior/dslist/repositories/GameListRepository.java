package com.devsuperior.dslist.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.GameList;

//O repository é quem executa os comandos tipo SELECT, INSERT, DELETE... mas sem você escrever SQL na mão.
public interface GameListRepository extends JpaRepository<GameList, Long>{ //passa a entity e o id
	@Modifying //quando eh um DML, insert, update... modificando e nao apenas consultando
	@Query(nativeQuery = true, value = "UPDATE tb_belonging SET position = :newPosition WHERE list_id = :listId AND game_id = :gameId")
	void updateBelongingPosition(Long listId, Long gameId, Integer newPosition);
	}
