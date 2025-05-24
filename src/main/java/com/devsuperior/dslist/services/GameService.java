package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

//registre o componente
@Service 
public class GameService {
	
	@Autowired //injetando um objeto do GameRepository no meu GameService. Componente chamando outro componente
	private GameRepository gameRepository;
	
	@Transactional(readOnly= true)
	public List<GameMinDTO> findAll(){ //retorna toda a entidade Game
		List<Game> result = gameRepository.findAll(); //pega todos registros da entity
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); //Pega a lista game (result).transforma cada elemento Game em um GameMinDTO, devolva isso como uma nova lista
		/*
			é a mesma coisa que fazer:
			List<GameMinDTO> dto = new ArrayList<>();
			for (Game x : result){
			dto.add(new GameMinDTO(x));
			}
		 */
		
		return dto;
	}
	
	@Transactional(readOnly= true)  //fala q nao vou fazer nada de escrita, logo, ficando mais rapido apenas lendo.
	//transactional - ACID, transação no banco de dados para que ou execute tudo com sucesso, ou estoure um erro e cancele caso qualquer coisa de errado
	public GameDTO findById(Long gameId) {
		Game g = gameRepository.findById(gameId).get(); 
		GameDTO dto = new GameDTO(g); //construtor GameDTO recebe um objeto game e transforma em objeto GameDTO (lembrando q eles tem os msm campos) 
		return dto;
	}
}
