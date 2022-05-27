package com.BugLess.dto;

import java.io.Serializable;

import com.BugLess.entity.MarcadorLocalizacao;

public class MarcadorLocalizacaoDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Long id;
	private Double lat;
	private Double lng;
	private String nome;
	
	public MarcadorLocalizacaoDTO() {
		super();
	}

	public MarcadorLocalizacaoDTO(Long id, Double lat, Double lng, String nome) {
		super();
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.nome = nome;
	}
	
	public MarcadorLocalizacao convertToEntity() {
		return new MarcadorLocalizacao(getId(),
									   getLat(), 
				                       getLng(),
				                       getNome());
	};

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Double getLat() {
		return lat;
	}

	public void setLat(Double lat) {
		this.lat = lat;
	}

	public Double getLng() {
		return lng;
	}

	public void setLng(Double lng) {
		this.lng = lng;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
