package com.devsuperior.dslist.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.entities.GameList;
import com.devsuperior.dslist.projections.GameMinProjection;
import com.devsuperior.dslist.repositories.GameListRepository;
import com.devsuperior.dslist.repositories.GameRepository;

//registre o componente
@Service 
public class GameListService {
	
	@Autowired //injetando um objeto do GameRepository no meu GameService. Componente chamando outro componente
	private GameListRepository gameListRepository;
	
	@Autowired
	private GameRepository gameRepostory;
	
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
	
	@Transactional
	public void move(Long listId, int posicaoOrigem, int posicaoDestino) {
		List<GameMinProjection> list = gameRepostory.searchByList(listId);
		
		//pra fazermos a logica de mover o jogo da posicao (3), e coloca-lo na (1), temos q remover o jogo da posicao (3) e adiciona-lo na (1)
		
		GameMinProjection obj = list.remove(posicaoOrigem);
		list.add(posicaoDestino, obj);
		
		int nMin= posicaoOrigem < posicaoDestino? posicaoOrigem : posicaoDestino;
		int nMax = posicaoOrigem < posicaoDestino? posicaoDestino : posicaoOrigem;
		
		//iterando entre a posicaoDeOrigem e a Destino. Ao invés de atualizar toda a lista, só atualizo naquele intervalo q foi alterado
		for(int i = nMin; i<=nMax; i++) {
			gameListRepository.updateBelongingPosition(listId, list.get(i).getId(), i);
		}
	}
	
}
