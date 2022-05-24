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

import com.BugLess.dto.LocalizacaoDTO;
import com.BugLess.entity.Bairro;
import com.BugLess.service.LocalizacaoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/localizacao")
public class LocalizacaoController {
	
	@Autowired
	LocalizacaoService service;
	
	@GetMapping
	public List<LocalizacaoDTO> listAll(){
		return service.getAll();
	}
	
	@GetMapping("/bairros")
	public List<Bairro> countTotalLocalizacaosByBairroClass(){
		return service.countTotalLocalizacaosByBairroClass();
	}
	
	@GetMapping("/{id}")
	public LocalizacaoDTO getById(@PathVariable("id") Long id) throws Exception {
		return service.getById(id);
	}

	@PostMapping
	public ResponseEntity<LocalizacaoDTO> save(@RequestBody LocalizacaoDTO cadastro) {
		return new ResponseEntity<LocalizacaoDTO>(service.save(cadastro), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) throws Exception {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<LocalizacaoDTO> update(@RequestBody LocalizacaoDTO obj) throws Exception {

		return new ResponseEntity<LocalizacaoDTO>(service.update(obj), HttpStatus.OK);
	}
}
