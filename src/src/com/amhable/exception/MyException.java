package com.amhable.exception;

import org.hibernate.HibernateException;

@SuppressWarnings("serial")
public class MyException extends Exception {
	
	/**
	 * Clase que permite controlar las excepciones 
	 * @author luisa
	 */
	
	public  MyException(HibernateException e){
		super();
	}
	
	public  MyException(String Mensaje){
		super(Mensaje);
	}
}