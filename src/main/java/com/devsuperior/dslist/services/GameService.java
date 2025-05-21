package com.devsuperior.dslist.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.entities.Game;
import com.devsuperior.dslist.repositories.GameRepository;

//registre o componente
@Service 
public class GameService {
	
	@Autowired //injetando um objeto do GameRepository no meu GameService. Componente chamando outro componente
	private GameRepository gameRepository;
	
	public List<GameMinDTO> findAll(){ //retorna toda a entidade Game
		List<Game> result = gameRepository.findAll(); //pega todos registros da entity
		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); //Pega a lista game (result).transforma cada elemento Game em um GameMinDTO, devolva isso como uma nova lista
		/*
			é a mesma coisa que fazer:
			List<GameMinDTO> dto = new ArrayList<>();
			for (Game x : result){
			dto.add(new GameMinDTO(game));
			}
		 */
		
		return dto;
	}
}
