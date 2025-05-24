package com.devsuperior.dslist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.repositories.GameListRepository;

//registre o componente
@Service 
public class GameListService {
	
	@Autowired //injetando um objeto do GameRepository no meu GameService. Componente chamando outro componente
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly= true)
	public List<GameListDTO> findAll(){ //retorna toda a entidade GameList, nativo do JPA esse metodo
		List<GameList> result = gameListRepository.findAll(); //pega todos registros da entity
//		List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList(); 
		List<GameListDTO> dto = new ArrayList<>();
		for(GameList g:result) {
			dto.add(new GameListDTO(g)); //para converter, lembre-se q deve passar dentro do constructor
		}
		
//		List<GameListDTO> dto = result.stream().map(x -> new GameListDTO(x)).toList(); //outra forma de se fazer
		
		return dto;
	}
	
}
