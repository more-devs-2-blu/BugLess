package com.BugLess.dto;

import com.BugLess.entity.Localizacao;

public class LocalizacaoDTO{
	
	private Long id;
	private String cep;
	private String logradouro;
	private Integer numero;
	private String bairro;
	private String localidade;
	private String uf;
	
	public LocalizacaoDTO() {
		super();
	}

	
	public LocalizacaoDTO(Long id, String cep, String logradouro, Integer numero, String bairro, String localidade,
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


	public Localizacao convertToEntity() {
		return new Localizacao(getId(),
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
