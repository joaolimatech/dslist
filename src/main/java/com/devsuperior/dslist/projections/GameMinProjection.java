package com.devsuperior.dslist.projections;

public interface GameMinProjection {

	//metodos gets correspondente a sua consulta
	Long getId();
	String getTitle();
	Integer getGameYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
}
