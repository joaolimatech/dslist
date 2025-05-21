package com.devsuperior.dslist.dto;

import com.devsuperior.dslist.entities.Game;

/*
 * É um objeto simplificado que serve pra transportar dados de uma camada pra outra (geralmente do back pro front).

👉 Pra que serve:
Pra você não expor a entidade inteira. Manda só o que interessa (tipo id, title e imgURL)no JSON, deixando mais seguro, leve e organizado.
 * */

public class GameMinDTO {
	
	private Long id;
	private String title;
	private Integer year;
	private String imgUrl;
	private String shortDescription;
	
	public GameMinDTO() {}

	public GameMinDTO(Game entity) { //passando um objeto da classe Entity como parametro

		this.id = entity.getId();
		this.title = entity.getTitle();
		this.year = entity.getYear();
		this.imgUrl = entity.getImgUrl();
		this.shortDescription = entity.getShortDescription();
	}
	
	//No DTO só precisamos de getters
	 

	public Long getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public Integer getYear() {
		return year;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public String getShortDescription() {
		return shortDescription;
	}
	
	
	
}
