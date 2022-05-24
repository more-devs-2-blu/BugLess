package com.BugLess.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BugLess.dto.LocalizacaoDTO;
import com.BugLess.entity.Bairro;
import com.BugLess.entity.Localizacao;
import com.BugLess.repository.LocalizacaoRepository;

@Service
public class LocalizacaoService {
	
	@Autowired
	LocalizacaoRepository repository;
	
	public List<LocalizacaoDTO> getAll(){
		List<Localizacao> localizacoes = repository.findAll();
		List<LocalizacaoDTO> listDTOs = new ArrayList<>();
		
		for(Localizacao localizacao : localizacoes) {
			listDTOs.add(localizacao.getDTO()); 
		}
		
		return listDTOs;
	}
	
	public List<Bairro> countTotalLocalizacaosByBairroClass() {
		List<Bairro> bairros = repository.countTotalLocalizacaosByBairroClass();
		
		return bairros;
	}
	
	public LocalizacaoDTO getById(Long id) throws Exception {
		Localizacao localizacao = repository.findById(id)
									  .orElseThrow(
											  ()-> new Exception("Localização inexistente"));
		return localizacao.getDTO();
	}
	
	public LocalizacaoDTO save(LocalizacaoDTO dto) {
		Localizacao localizacao = repository.save(dto.convertToEntity());
		return localizacao.getDTO();
	}
	
	public Boolean delete(Long id) throws Exception {
		Localizacao delLoc = repository.findById(id)
									.orElseThrow(
												()-> new Exception("Cadastro não localizado"));
		repository.delete(delLoc);
		return true;
	}
	
	public LocalizacaoDTO update(LocalizacaoDTO obj) throws Exception {
		getById(obj.getId());
		return save(obj);
			
		}
}
