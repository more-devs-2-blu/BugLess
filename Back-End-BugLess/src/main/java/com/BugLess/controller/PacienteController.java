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

import com.BugLess.dto.PacienteDTO;
import com.BugLess.service.PacienteService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/paciente")
public class PacienteController {

	@Autowired
	PacienteService service;

	@GetMapping
	public List<PacienteDTO> listAll() {
		return service.getAll();
	}

	@GetMapping("/{id}")
	public PacienteDTO getById(@PathVariable("id") Long id) throws Exception {
		return service.getById(id);
	}

	@PostMapping
	public ResponseEntity<PacienteDTO> save(@RequestBody PacienteDTO cadastro) {
		return new ResponseEntity<PacienteDTO>(service.save(cadastro), HttpStatus.CREATED);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Boolean> delete(@PathVariable("id") Long id) throws Exception {
		return new ResponseEntity<>(service.delete(id), HttpStatus.OK);
	}

	@PutMapping
	public ResponseEntity<PacienteDTO> update(@RequestBody PacienteDTO obj) throws Exception {

		return new ResponseEntity<PacienteDTO>(service.update(obj), HttpStatus.OK);
	}

}
