package com.htw.test.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/***********
 * 
 * @author ARadunski
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND) //404
public class EntityNotFoundException extends RuntimeException{
	
	private static final long seriaVersionUID = 1613731506423884184L;
	
	/*************************************
	 * @param message
	 */
	
	public EntityNotFoundException(String message){
		super(message);
	}

}
