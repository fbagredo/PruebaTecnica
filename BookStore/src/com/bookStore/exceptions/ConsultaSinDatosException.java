package com.bookStore.exceptions;

public class ConsultaSinDatosException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1946238996618507483L;

	/**
	 * 
	 */
	public ConsultaSinDatosException(){
		super("La consulta no arrojo resultados.");
	}

}
