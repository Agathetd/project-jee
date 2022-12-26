package com.univlittoral.projetback.mapper;

import java.util.ArrayList;
import java.util.List;

import com.univlittoral.projetback.dto.AuteurDTO;
import com.univlittoral.projetback.entity.AuteurEntity;

public class AuteurMapper {
	public static AuteurDTO convertEntityToDTO(AuteurEntity auteurEntity){
		AuteurDTO auteurDto = new AuteurDTO();
		
		auteurDto.setId(auteurEntity.getId());
		auteurDto.setNom(auteurEntity.getNom());
		auteurDto.setPrenom(auteurEntity.getPrenom());
		auteurDto.setDateNaissance(auteurEntity.getDateNaissance());

		return auteurDto;
	}
	
	public static AuteurEntity convertDTOToEntity(AuteurDTO auteurDto) {
		AuteurEntity auteurEntity = new AuteurEntity();
		
		auteurEntity.setId(auteurDto.getId());
		auteurEntity.setPrenom(auteurDto.getPrenom());
		auteurEntity.setNom(auteurDto.getNom());
		auteurEntity.setDateNaissance(auteurDto.getDateNaissance());

		
		return auteurEntity;
	}

	public static List<AuteurDTO>convertDTOToEntity(List<AuteurEntity> auteurEntities){
		List<AuteurDTO>result= new ArrayList<AuteurDTO>();
		for(final AuteurEntity entity : auteurEntities) {
			result.add(AuteurMapper.convertEntityToDTO(entity));
		}
		
		return result;
	}
}
