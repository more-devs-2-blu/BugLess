package com.BugLess.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.BugLess.dto.EnderecoDTO;
import com.BugLess.entity.Bairro;
import com.BugLess.service.EnderecoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/localizacao")
public class EnderecoController {
	
	@Autowired
	EnderecoService service;
	
	@GetMapping
	public List<EnderecoDTO> listAll(){
		return service.getAll();
	}
	
	@GetMapping("/bairros")
	public List<Bairro> countTotalLocalizacaosByBairroClass(){
		return service.countTotalLocalizacaosByBairroClass();
	}
	
	@GetMapping("/{id}")
	public EnderecoDTO getById(@PathVariable("id") Long id) throws Exception {
		return service.getById(id);
	}

	@PostMapping
	public ResponseEntity<EnderecoDTO> save(@RequestBody EnderecoDTO cadastro) {
		return new ResponseEntity<EnderecoDTO>(service.save(cadastro), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<EnderecoDTO> update(@RequestBody EnderecoDTO obj) throws Exception {

		return new ResponseEntity<EnderecoDTO>(service.update(obj), HttpStatus.OK);
	}
}
