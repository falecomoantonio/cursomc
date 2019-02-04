package br.com.cursomc.exceptions;

public class UnprocessableEntityException extends RuntimeException {	
	
	private static final long serialVersionUID = 1L;

	public UnprocessableEntityException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UnprocessableEntityException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public UnprocessableEntityException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public UnprocessableEntityException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public UnprocessableEntityException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	} 
}
