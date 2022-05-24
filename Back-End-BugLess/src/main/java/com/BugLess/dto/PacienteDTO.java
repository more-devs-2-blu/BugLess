package com.BugLess.dto;

import java.time.LocalDate;

import com.BugLess.entity.Localizacao;
import com.BugLess.entity.Paciente;
import com.fasterxml.jackson.annotation.JsonFormat;

public class PacienteDTO {
	
	private Long id;
	private String nome; 
	private String cpf;
	private Integer idade;
	private String sexo;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate dataCadastro = LocalDate.now();

	private Localizacao endereco;
	
	public PacienteDTO() {
		super();
	}

	public PacienteDTO(Long id, String nome, String cpf, Integer idade, String sexo, Localizacao endereco) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.idade = idade;
		this.sexo = sexo;
//		this.data = data;
		this.endereco = endereco;
	}
	
	public Paciente convertToEntity() {
		return new Paciente(getId(),
				               getNome(), 
				               getCpf(), 
				               getIdade(),
				               getSexo(),
				               getEndereco());
	};

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public Integer getIdade() {
		return idade;
	}

	public void setIdade(Integer idade) {
		this.idade = idade;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public LocalDate getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(LocalDate dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Localizacao getEndereco() {
		return endereco;
	}

	public void setEndereco(Localizacao endereco) {
		this.endereco = endereco;
	}
}
