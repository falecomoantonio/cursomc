package br.com.cursomc.handler;

import java.io.Serializable;

public class StandardError implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer code;
	
	private String message;
	
	private Long timestamp;
	
	public StandardError() {
		this.code = 0;
		this.message = "";
		this.timestamp = 0L;
	}
	
	public StandardError(Integer code, String message) {
		this.code = code;
		this.message = message;
		this.timestamp = System.currentTimeMillis();
	}

	public StandardError(Integer code, String message, Long timestamp) {
		this.code = code;
		this.message = message;
		this.timestamp = timestamp;
	}



	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}
	
	

}
