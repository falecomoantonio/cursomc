package br.com.cursomc.exceptions;

public class DefaultException  extends RuntimeException {	
	
	private static final long serialVersionUID = 1L;

	public DefaultException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DefaultException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public DefaultException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public DefaultException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public DefaultException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	} 
}
