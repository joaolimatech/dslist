package com.devsuperior.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameDTO;
import com.devsuperior.dslist.dto.GameMinDTO;
import com.devsuperior.dslist.services.GameService;

//porta de entrada do nosso backend... ele q vai disponibilizar nossa API

@RestController
@RequestMapping(value = "/games") //conceito de recurso, recurso games. Configurando o caminho q será respondido na API
public class GameController {

	@Autowired //"injetando"/criando um objeto service
	private GameService gameService;
	
	@GetMapping(value = "/{id}")
	public GameDTO findById(@PathVariable Long id){ //Indica que esse será o id q é enviado na requisicao
		GameDTO resultado = gameService.findById(id);
		return resultado;
	}
	
	@GetMapping()
	public List<GameMinDTO> findAll(){
		List<GameMinDTO> resultado = gameService.findAll();
		return resultado; 
	}
	
	
}
