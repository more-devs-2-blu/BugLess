package com.BugLess.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.BugLess.dto.MarcadorLocalizacaoDTO;

@Entity
@Table(name = "tb_coordenadas")
public class MarcadorLocalizacao implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(nullable = false)
	private Double lat;
	@Column(nullable = false)
	private Double lng;
	@Column(nullable = false)
	private String nome;
	
	public MarcadorLocalizacao() {
		super();
	}

	public MarcadorLocalizacao(Long id, Double lat, Double lng, String nome) {
		super();
		this.id = id;
		this.lat = lat;
		this.lng = lng;
		this.nome = nome;
	}
	
	public MarcadorLocalizacaoDTO getDTO() {
		return new MarcadorLocalizacaoDTO(getId(),
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
