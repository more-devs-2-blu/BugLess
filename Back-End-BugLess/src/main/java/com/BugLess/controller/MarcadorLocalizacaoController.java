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

import com.BugLess.dto.MarcadorLocalizacaoDTO;
import com.BugLess.service.MarcadorLocalizacaoService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/marcador")
public class MarcadorLocalizacaoController {

	@Autowired
	MarcadorLocalizacaoService service;

	@GetMapping
	public List<MarcadorLocalizacaoDTO> listAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public MarcadorLocalizacaoDTO getById(@PathVariable("id") Long id) throws Exception {
		return service.getById(id);
	}

	@PostMapping
	public ResponseEntity<MarcadorLocalizacaoDTO> save(@RequestBody MarcadorLocalizacaoDTO marcador) {
		return new ResponseEntity<MarcadorLocalizacaoDTO>(service.save(marcador), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable("id") Long id) throws Exception {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@PutMapping
	public ResponseEntity<MarcadorLocalizacaoDTO> update(@RequestBody MarcadorLocalizacaoDTO obj) throws Exception {

		return new ResponseEntity<MarcadorLocalizacaoDTO>(service.update(obj), HttpStatus.OK);
	}

}
