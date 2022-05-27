package com.BugLess.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.validation.ConstraintViolationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.BugLess.dto.PacienteDTO;
import com.BugLess.entity.Endereco;
import com.BugLess.entity.Paciente;
import com.BugLess.repository.EnderecoRepository;
import com.BugLess.repository.PacienteRepository;
import com.BugLess.service.exceptions.DataBaseException;
import com.BugLess.service.exceptions.InvalidCpfException;
import com.BugLess.service.exceptions.ResourceNotFoundException;

@Service
public class PacienteService {
	
	@Autowired
	PacienteRepository repository;
	
	@Autowired
	EnderecoRepository enderecoRepository;
	
	public List<PacienteDTO> getAll(){
		List<Paciente> pacientes = repository.findAll();
		List<PacienteDTO> listDTOs = new ArrayList<>();
		
		for(Paciente paciente : pacientes) {
			listDTOs.add(paciente.getDTO()); 
		}
		
		return listDTOs;
	}
	
	public PacienteDTO getById(Long id) {
		Optional<Paciente> paciente = repository.findById(id);
		
		return paciente.orElseThrow(()-> new ResourceNotFoundException(id)).getDTO();
	}
	
	public PacienteDTO save(PacienteDTO dto) {
		try {
			Endereco endereco = new Endereco();
			saveData(dto, endereco);
			Paciente paciente = repository.save(dto.convertToEntity());
			return paciente.getDTO();
		}
		catch(DataIntegrityViolationException e) {
			// Trata o caso de duplicacao do cpf
			throw new InvalidCpfException(e.getMessage());
		}
		catch(ConstraintViolationException e) {
			// Trata o caso de cpf invalido
			throw new InvalidCpfException(e.getMessage());
		}
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
	
	public PacienteDTO update(PacienteDTO obj) throws Exception {
		getById(obj.getId());
		return save(obj);
			
		}
	
	private void saveData(PacienteDTO dto, Endereco endereco) {
//		Pega as info do endereco do paciente e seta no novo ojbeto localizacao
		endereco.setBairro(dto.getEndereco().getBairro());
		endereco.setCep(dto.getEndereco().getCep());
		endereco.setLogradouro(dto.getEndereco().getLogradouro());
		endereco.setLocalidade(dto.getEndereco().getLocalidade());
		endereco.setNumero(dto.getEndereco().getNumero());
		endereco.setUf(dto.getEndereco().getUf());
		
//		Salva o endereco do paciente no banco e atribui o endereço ao paciente
		enderecoRepository.save(endereco);
		dto.setEndereco(endereco);
	}
}
