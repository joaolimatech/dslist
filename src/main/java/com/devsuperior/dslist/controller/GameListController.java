package com.devsuperior.dslist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.devsuperior.dslist.dto.GameListDTO;
import com.devsuperior.dslist.services.GameListService;

//porta de entrada do nosso backend... ele q vai disponibilizar nossa API

@RestController
@RequestMapping(value = "/lists") //conceito de recurso, recurso games. Configurando o caminho q será respondido na API
public class GameListController {

	@Autowired //"injetando"/criando um objeto service
	private GameListService gameListService;
	

	@GetMapping()
	public List<GameListDTO> findAll(){
		List<GameListDTO> resultado = gameListService.findAll(); 
		return resultado; 
	}
	
	
}
