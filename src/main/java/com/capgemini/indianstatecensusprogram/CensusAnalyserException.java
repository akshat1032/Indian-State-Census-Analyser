package com.capgemini.indianstatecensusprogram;

public class CensusAnalyserException extends Exception {
	
	public enum TypeOfException{
		INCORRECT_FILE_EXCEPTION;
	}
	
	TypeOfException typeOfException;
	public CensusAnalyserException(String message, TypeOfException typeOfException) {
		super(message);
		this.typeOfException = typeOfException;
	}
	
//	 @return the Type Of Exception
	public TypeOfException getTypeOfException() {
		return typeOfException;
	}
	
	
}
