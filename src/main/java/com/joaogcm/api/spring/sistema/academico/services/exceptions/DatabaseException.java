package com.joaogcm.api.spring.sistema.academico.services.exceptions;

public class DatabaseException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DatabaseException(String mensagem) {
		super(mensagem);
	}
}
