package com.univlittoral.projetback.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.univlittoral.projetback.dto.LivreDTO;
import com.univlittoral.projetback.entity.LivreEntity;
import com.univlittoral.projetback.mapper.LivreMapper;
import com.univlittoral.projetback.repository.LivreRepository;

@Service
public class LivreService {
	
	@Autowired
	private LivreRepository repo;
	
	public List<LivreEntity> findLivre() {
		return repo.findAll();
	}
	
	public LivreEntity findLivreById(Long id) {
		return repo.findById(id).orElse(null);
	}
	
	public void deleteLivreById(Long id) {
		repo.deleteById(id);
	}
	
	public void addLivre(LivreEntity livreEntity) {
		repo.save(livreEntity);		
	}
	
	public void modifyLivre(LivreEntity livreEntity) {
		repo.save(livreEntity);
	}
	
	public List<LivreEntity> findLivreByGenre(String genre){
		return repo.findLivreByGenre(genre);
	}
	

}
