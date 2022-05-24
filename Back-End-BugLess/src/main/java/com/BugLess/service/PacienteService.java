package com.BugLess.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.BugLess.dto.PacienteDTO;
import com.BugLess.entity.Localizacao;
import com.BugLess.entity.Paciente;
import com.BugLess.repository.LocalizacaoRepository;
import com.BugLess.repository.PacienteRepository;

@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository repository;
	
	@Autowired
	LocalizacaoRepository localizacaoRepository;
	
	public List<PacienteDTO> getAll(){
		List<Paciente> pacientes = repository.findAll();
		List<PacienteDTO> listDTOs = new ArrayList<>();
		
		for(Paciente paciente : pacientes) {
			listDTOs.add(paciente.getDTO()); 
		}
		
		return listDTOs;
	}
	
	public PacienteDTO getById(Long id) throws Exception {
		Paciente paciente = repository.findById(id)
									  .orElseThrow(
											  ()-> new Exception("Cadastro não localizado"));
		return paciente.getDTO();
	}
	
	public PacienteDTO save(PacienteDTO dto) {
		Localizacao localizacao = new Localizacao();
		
//		Pega as info do endereco do paciente e seta no novo ojbeto localizacao
		localizacao.setBairro(dto.getEndereco().getBairro());
		localizacao.setCep(dto.getEndereco().getCep());
		localizacao.setLogradouro(dto.getEndereco().getLogradouro());
		localizacao.setLocalidade(dto.getEndereco().getLocalidade());
		localizacao.setNumero(dto.getEndereco().getNumero());
		localizacao.setUf(dto.getEndereco().getUf());
		
//		Salva o endereco do paciente no banco e atribui o endereço ao paciente
		localizacaoRepository.save(localizacao);
		dto.setEndereco(localizacao);
		
		Paciente paciente = repository.save(dto.convertToEntity());
		return paciente.getDTO();
	}
	
	public Boolean delete(Long id) throws Exception {
		Paciente delPac = repository.findById(id)
									.orElseThrow(
												()-> new Exception("Cadastro não localizado"));
		repository.delete(delPac);
		return true;
	}
	
	public PacienteDTO update(PacienteDTO obj) throws Exception {
		getById(obj.getId());
		return save(obj);
			
		}
	

}
