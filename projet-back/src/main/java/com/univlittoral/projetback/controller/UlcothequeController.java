package com.univlittoral.projetback.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.univlittoral.projetback.dto.AuteurDTO;
import com.univlittoral.projetback.dto.HomeDTO;
import com.univlittoral.projetback.dto.IndicateurDTO;
import com.univlittoral.projetback.dto.LivreDTO;
import com.univlittoral.projetback.entity.AuteurEntity;
import com.univlittoral.projetback.entity.LivreEntity;
import com.univlittoral.projetback.enums.GenreEnum;
import com.univlittoral.projetback.mapper.AuteurMapper;
import com.univlittoral.projetback.mapper.LivreMapper;
import com.univlittoral.projetback.service.AuteurService;
import com.univlittoral.projetback.service.LivreService;


	
@RestController
@RequestMapping(value = "/rest/bd/")
public class UlcothequeController {
	 @Autowired
	 private LivreService service;
	 
	 @Autowired
	 private AuteurService auteurservice;
		
	 @GetMapping("/home")
	 public HomeDTO findLivre() {
		 	HomeDTO home = new HomeDTO();
		 	IndicateurDTO indicateurs = new IndicateurDTO();
		 	List<LivreEntity> LivresEntities = service.findLivre();
		 	List<LivreDTO> Livres = new ArrayList<LivreDTO>();
		 	List<AuteurEntity> Auteurs = auteurservice.findAuteur();
		 	
		 	
		 	for(LivreEntity livre : LivresEntities) {
		 		AuteurEntity auteurentity = auteurservice.findAuteurById(livre.getAuteur());
		 		System.out.println(livre.getAuteur());
		 		System.out.println(auteurentity);
		 		AuteurDTO auteurDto = AuteurMapper.convertEntityToDTO(auteurentity);
		 		LivreDTO livredto = LivreMapper.convertEntityToDTO(livre);
		 		livredto.setAuteur(auteurDto);
		 		Livres.add(livredto);
		 	}
		 	
		 	
		 	ArrayList<GenreEnum> listeGenres = new ArrayList<GenreEnum>();
		 	//ArrayList<Integer> listeAuteurs = new ArrayList<Integer>();
		 	
	        for (LivreDTO livre : Livres) {
	        	if(listeGenres.contains(livre.getGenre())) {
	        		System.out.println("Déjà dans le tableau");
	        	}else {
	        		listeGenres.add(livre.getGenre());
	        	}
	            
	        }
	        
	        /*for (LivreDTO livre : Livres) {
	        	if(listeAuteurs.contains(livre.getAuteur())) {
	        		System.out.println("Déjà dans le tableau");
	        	}else {
	        		listeAuteurs.add(livre.getAuteur());
	        	}
	        	
	        }*/
		 	
		 	indicateurs.setNbAuteurs(Auteurs.size());
		 	indicateurs.setNbGenres(listeGenres.size());
		 	indicateurs.setNbLivres(Livres.size());
		 	
		 	home.setLivres(Livres);
		 	home.setIndicateurs(indicateurs);
		 	
		 	return home;
	 }
	 
	 @GetMapping("/livres/{id}")
	 public LivreDTO findLivreById(@PathVariable Long id) {
		 return LivreMapper.convertEntityToDTO(service.findLivreById(id));
	 }
	 
	 @DeleteMapping("/livres/{id}")
	 public void deleteLivreById(@PathVariable Long id) {
		 service.deleteLivreById(id);
	 }
	 
	 @PutMapping("/livres/{id}")
	 public void modifyLivreById(@PathVariable Long id, @RequestBody LivreDTO livreDto) {
		 LivreEntity livre = LivreMapper.convertDTOToEntity(livreDto);
		 livre.setId(id);
		 service.modifyLivre(livre);
	 }
	 
	 @PostMapping("/livres/")
	 public void addLivre(@RequestBody LivreDTO livreDto) {
		 service.addLivre(LivreMapper.convertDTOToEntity(livreDto));
	 }
	 
	 @GetMapping("/livres")
	 public List<LivreDTO> findLivreByGenre(@RequestParam(value="genre") String genre) {
		 return LivreMapper.convertEntityToDTOList(service.findLivreByGenre(genre));
	 }
	 
	 @GetMapping("/auteurs/")
	 public List<AuteurDTO> findAuteur() {
		 return AuteurMapper.convertDTOToEntity(auteurservice.findAuteur());
	 }
	 
	 @GetMapping("/auteurs/{id}")
	 public AuteurDTO findAuteurById(@PathVariable Long id) {
		 return AuteurMapper.convertEntityToDTO(auteurservice.findAuteurById(id));
	 }
	 
}

