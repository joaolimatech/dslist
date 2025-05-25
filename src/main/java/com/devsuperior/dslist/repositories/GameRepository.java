package com.devsuperior.dslist.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.projections.GameMinProjection;


//O repository é quem executa os comandos tipo SELECT, INSERT, DELETE... mas sem você escrever SQL na mão.
public interface GameRepository extends JpaRepository<Game, Long>{
	@Query(nativeQuery = true, value = """
			SELECT tb_game.id, tb_game.title, tb_game.game_year AS gameYear, tb_game.img_url AS imgUrl,
			tb_game.short_description AS shortDescription, tb_belonging.position
			FROM tb_game
			INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
			WHERE tb_belonging.list_id = :listId
			ORDER BY tb_belonging.position
				""")
	List<GameMinProjection> searchByList(Long listId);

	//uma Projection é  uma interface especial para receber dados de uma consulta SQL. Quando é um SQL, o resultado da consulta deve ser uma projection
	//O jpa tem seu proprio "SQL", a JPQL... se quiser copiar um comando SQL, coloque o parametro nativeQuery
}
