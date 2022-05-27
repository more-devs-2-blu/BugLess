package com.BugLess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.BugLess.dto.MarcadorLocalizacaoDTO;
import com.BugLess.entity.MarcadorLocalizacao;
import com.BugLess.repository.MarcadorLocalizacaoRepository;
import com.BugLess.service.exceptions.DataBaseException;
import com.BugLess.service.exceptions.ResourceNotFoundException;

@Service
public class MarcadorLocalizacaoService {
	
	@Autowired
	MarcadorLocalizacaoRepository repository;
	
	public List<MarcadorLocalizacaoDTO> getAll(){
		List<MarcadorLocalizacao> marcadores = repository.findAll();
		List<MarcadorLocalizacaoDTO> listDTOs = new ArrayList<>();
		
		for(MarcadorLocalizacao marcador : marcadores) {
			listDTOs.add(marcador.getDTO()); 
		}
		
		return listDTOs;
	}
	
	public MarcadorLocalizacaoDTO getById(Long id) {
		Optional<MarcadorLocalizacao> marc = repository.findById(id);
		
		return marc.orElseThrow(()-> new ResourceNotFoundException(id)).getDTO();
	}
	
	public MarcadorLocalizacaoDTO save(MarcadorLocalizacaoDTO dto) {
		MarcadorLocalizacao marcador = repository.save(dto.convertToEntity());
		return marcador.getDTO();
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}
		catch(DataIntegrityViolationException e) {
			throw new DataBaseException(e.getMessage());
		}			
	}
	
	public MarcadorLocalizacaoDTO update(MarcadorLocalizacaoDTO obj) throws Exception {
		getById(obj.getId());
		return save(obj);
			
		}

}
