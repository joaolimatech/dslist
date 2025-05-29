package com.devsuperior.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.dto.ReplacementDTO;
import com.devsuperior.dslist.services.GameListService;
import com.devsuperior.dslist.services.GameService;

//porta de entrada do nosso backend... ele q vai disponibilizar nossa API

@RestController
@RequestMapping(value = "/lists") //conceito de recurso, recurso games. Configurando o caminho q será respondido na API
public class GameListController {

	@Autowired //"injetando"/criando um objeto service
	private GameListService gameListService;
	@Autowired
	private GameService gameService;
	

	@GetMapping()
	public List<GameListDTO> findAll(){
		List<GameListDTO> resultado = gameListService.findAll(); 
		return resultado; 
	}
	

	@GetMapping(value = "/{listId}/games") //qqsaber todos os games de determinada lista
	public List<GameMinDTO> findById(@PathVariable Long listId){
		List<GameMinDTO> resultado = gameService.findByList(listId); 
		return resultado; 
	}
	
	@PostMapping(value = "/{listId}/replacement")
	public void  move(@PathVariable Long listId, @RequestBody ReplacementDTO body /*recebe o corpo da requisicao*/){
	  gameListService.move(listId, body.getPosicaoOrigem(), body.getPosicaoDestino());
	}
	
	
}
