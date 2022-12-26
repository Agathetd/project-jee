package com.univlittoral.projetback.dto;

import java.util.List;

public class HomeDTO {

	private List<LivreDTO> livres;
	private IndicateurDTO indicateurs;
	private GraphDTO graph;
	private String genre;
	
	
	public List<LivreDTO> getLivres() {
		return livres;
	}
	public void setLivres(List<LivreDTO> livres) {
		this.livres = livres;
	}
	public IndicateurDTO getIndicateurs() {
		return indicateurs;
	}
	public void setIndicateurs(IndicateurDTO indicateurs) {
		this.indicateurs = indicateurs;
	}
	public GraphDTO getGraph() {
		return graph;
	}
	public void setGraph(GraphDTO graph) {
		this.graph = graph;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}

}
