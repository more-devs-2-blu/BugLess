package com.BugLess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.BugLess.dto.EnderecoDTO;
import com.BugLess.entity.Bairro;
import com.BugLess.entity.Endereco;
import com.BugLess.repository.EnderecoRepository;
import com.BugLess.service.exceptions.DataBaseException;
import com.BugLess.service.exceptions.ResourceNotFoundException;

@Service
public class EnderecoService {
	
	@Autowired
	EnderecoRepository repository;
	
	public List<EnderecoDTO> getAll(){
		List<Endereco> localizacoes = repository.findAll();
		List<EnderecoDTO> listDTOs = new ArrayList<>();
		
		for(Endereco localizacao : localizacoes) {
			listDTOs.add(localizacao.getDTO()); 
		}
		
		return listDTOs;
	}
	
	public List<Bairro> countTotalLocalizacaosByBairroClass() {
		List<Bairro> bairros = repository.countTotalLocalizacaosByBairroClass();
		
		return bairros;
	}
	
	public EnderecoDTO getById(Long id) {
		Optional<Endereco> endereco = repository.findById(id);
		
		return endereco.orElseThrow(()-> new ResourceNotFoundException(id)).getDTO();
	}
	
	public EnderecoDTO save(EnderecoDTO dto) {
		Endereco localizacao = repository.save(dto.convertToEntity());
		return localizacao.getDTO();
	}
	
	public void delete(Long id)  {
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
	
	public EnderecoDTO update(EnderecoDTO obj) throws Exception {
		getById(obj.getId());
		return save(obj);
			
		}
}
