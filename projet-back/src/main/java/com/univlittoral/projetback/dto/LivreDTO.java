package com.univlittoral.projetback.dto;

import java.sql.Date;

import com.univlittoral.projetback.enums.GenreEnum;

public class LivreDTO {
	
	private Long id;

	private String editeur;
	private String nom;
	private String lieuParution;
	private AuteurDTO auteur;
	private GenreEnum genre;
	private Integer nbPages;
	private Date DateParution;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEditeur() {
		return editeur;
	}
	public void setEditeur(String editeur) {
		this.editeur = editeur;
	}
	public String getLieuParution() {
		return lieuParution;
	}
	public void setLieuParution(String lieuParution) {
		this.lieuParution = lieuParution;
	}
	public GenreEnum getGenre() {
		return genre;
	}
	public void setGenre(GenreEnum genre) {
		this.genre = genre;
	}

	public AuteurDTO getAuteur() {
		return auteur;
	}
	public void setAuteur(AuteurDTO auteur) {
		this.auteur = auteur;
	}
	
	public Integer getNbPages() {
		return nbPages;
	}
	public void setNbPages(Integer nbPages) {
		this.nbPages = nbPages;
	}
	public Date getDateParution() {
		return DateParution;
	}
	public void setDateParution(Date dateParution) {
		DateParution = dateParution;
	}

	
}
