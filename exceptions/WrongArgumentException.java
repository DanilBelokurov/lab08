package org.suai.lab8.exceptions;

public class WrongArgumentException extends Exception{

	private static final long serialVersionUID = 1L;

	private String errorMassage;
	
	public WrongArgumentException(String whatWrong) {
		errorMassage = whatWrong;
	}

	public String getMassage() {
		return errorMassage;
	}
	
}
