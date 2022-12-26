package com.univlittoral.projetback.mapper;

import java.util.ArrayList;
import java.util.List;

import com.univlittoral.projetback.dto.LivreDTO;
import com.univlittoral.projetback.entity.LivreEntity;

public class LivreMapper {
	public static LivreDTO convertEntityToDTO(LivreEntity livreEntity){
		LivreDTO livreDto = new LivreDTO();
		
		livreDto.setId(livreEntity.getId());
		livreDto.setNom(livreEntity.getNom());
		livreDto.setEditeur(livreEntity.getEditeur());
		livreDto.setLieuParution(livreEntity.getLieuParution());
		livreDto.setGenre(livreEntity.getGenre());
		livreDto.setNbPages(livreEntity.getNbPages());
		livreDto.setDateParution(livreEntity.getDateParution());
		
		return livreDto;
	}
	
	public static LivreEntity convertDTOToEntity(LivreDTO livreDTO) {
		LivreEntity livreEntity = new LivreEntity();
		
		livreEntity.setId(livreDTO.getId());
		livreEntity.setGenre(livreDTO.getGenre());
		livreEntity.setNom(livreDTO.getNom());
		livreEntity.setAuteur(livreDTO.getAuteur().getId());
		livreEntity.setEditeur(livreDTO.getEditeur());
		livreEntity.setNbPages(livreDTO.getNbPages());
		livreEntity.setLieuParution(livreDTO.getLieuParution());
		livreEntity.setDateParution(livreDTO.getDateParution());
		
		return livreEntity;
	}

	public static List<LivreDTO>convertEntityToDTOList(List<LivreEntity> livreEntities){
		List<LivreDTO>result= new ArrayList<LivreDTO>();
		for(final LivreEntity entity : livreEntities) {
			result.add(LivreMapper.convertEntityToDTO(entity));
		}
		
		return result;
	}
	public static List<LivreEntity>convertListEntityToDTO(List<LivreDTO> livresDto){
		List<LivreEntity>result= new ArrayList<LivreEntity>();
		for(final LivreDTO Dto : livresDto) {
			result.add(LivreMapper.convertDTOToEntity(Dto));
		}
		
		return result;
	}
}
