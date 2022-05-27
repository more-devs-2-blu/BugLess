package com.BugLess.entity;

public class Bairro {
	
	private String bairro;
	private Long   total;
	
	public Bairro(String bairro, Long total) {
		super();
		this.bairro = bairro;
		this.total = total;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Long getTotal() {
		return total;
	}

	public void setTotal(Long total) {
		this.total = total;
	}
}
