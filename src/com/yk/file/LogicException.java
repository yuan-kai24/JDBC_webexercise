package com.yk.file;

public class LogicException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	
	/**
	 * 
	 * @param message	错误信息
	 * @param cause		错误原因
	 */
	public LogicException(String message, Throwable cause) {
		super(message, cause);
	}

	public LogicException(String massage) {
		super(massage);
	}

	
}
