package com.BugLess.service.exceptions;

public class InvalidCpfException extends RuntimeException {
	private static final long serialVersionUID = 1L;
	
	public InvalidCpfException(String msg) {
		super("Não foi possível autenticar o cpf!");
	}

}
