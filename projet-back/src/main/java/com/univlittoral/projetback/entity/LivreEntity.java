package com.univlittoral.projetback.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.univlittoral.projetback.enums.GenreEnum;


@Entity
@Table(name="livres")

public class LivreEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nom;
	private Long auteur;
	@Enumerated(EnumType.STRING)
	private GenreEnum genre;
	private String editeur;
	@Column(name="lieu_parution")
	private String lieuParution;
	@Column(name="nb_pages")
	private Integer nbPages;
	@Column(name="date_parution")
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
	public GenreEnum getGenre() {
		return genre;
	}
	public void setGenre(GenreEnum genre) {
		this.genre = genre;
	}
	public Long getAuteur() {
		return auteur;
	}
	public void setAuteur(Long auteur) {
		this.auteur = auteur;
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
