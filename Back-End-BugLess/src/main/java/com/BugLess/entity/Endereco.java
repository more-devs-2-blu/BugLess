package com.BugLess.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.BugLess.dto.EnderecoDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "tb_enderecos")
public class Endereco implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false)
	private String cep;
	
	@Column(nullable = false)
	private String logradouro;
	
	@Column(nullable = false)
	private Integer numero;
	
	@Column(nullable = false)
	private String bairro;
	
	@Column(nullable = false)
	private String localidade;
	
	@Column(nullable = false)
	private String uf;
	
	@JsonIgnore
	@OneToMany(mappedBy = "endereco")
	private List<Paciente> pacientes = new ArrayList<>();
	
	public Endereco() {
		super();
	}

	public Endereco(Long id, String cep, String logradouro, Integer numero, String bairro, String localidade,
			String uf) {
		super();
		this.id = id;
		this.cep = cep;
		this.logradouro = logradouro;
		this.numero = numero;
		this.bairro = bairro;
		this.localidade = localidade;
		this.uf = uf;
	}

	@JsonIgnore
	public EnderecoDTO getDTO() {
		return new EnderecoDTO(getId(),
				   				  getCep(),
				                  getLogradouro(),
				                  getNumero(),
				                  getBairro(),
				                  getLocalidade(),
				                  getUf());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}


	public String getLocalidade() {
		return localidade;
	}


	public void setLocalidade(String localidade) {
		this.localidade = localidade;
	}


	public String getLogradouro() {
		return logradouro;
	}


	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
}
