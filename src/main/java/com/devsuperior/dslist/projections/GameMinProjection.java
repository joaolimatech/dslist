package com.devsuperior.dslist.projections;

public interface GameMinProjection {

	//metodos gets correspondente a sua consulta
	Long getId();
	String getTitle();
	Integer getYear();
	String getImgUrl();
	String getShortDescription();
	Integer getPosition();
	
}
