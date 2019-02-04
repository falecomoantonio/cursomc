package br.com.cursomc.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import br.com.cursomc.exceptions.ObjectNotFoundException;
import br.com.cursomc.exceptions.UnprocessableEntityException;

@ControllerAdvice
public class SystemHandler {

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(ObjectNotFoundException.class)
	@ResponseBody 
	public StandardError resourceNotFound(HttpServletRequest req, Exception ex) {
	    return new StandardError(HttpStatus.NOT_FOUND.value(), ex.getMessage());
	} 

	@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
	@ExceptionHandler(UnprocessableEntityException.class)
	@ResponseBody 
	public StandardError entityNotProcessed(HttpServletRequest req, Exception ex) {
	    return new StandardError(HttpStatus.UNPROCESSABLE_ENTITY.value(), ex.getMessage());
	} 
	
}
