package br.com.cursomc.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value=HttpStatus.NOT_FOUND, reason="Erro no Servidor")
public class ServerErrorException extends RuntimeException { private static final long serialVersionUID = 1L; }
