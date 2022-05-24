package com.BugLess.entity;

public class Bairros {

	private String bairro;
	private Long quantidade;
	
	public Bairros() {
		
	}
	
	public Bairros(String bairro, Long quantidade) {
		super();
		this.bairro = bairro;
		this.quantidade = quantidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Long getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Long quantidade) {
		this.quantidade = quantidade;
	}
	
	
}
