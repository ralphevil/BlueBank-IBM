package com.example.bluebank.config;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.example.bluebank.request.ResponseModel;

@RestControllerAdvice
public class Handler {

	@ExceptionHandler(RuntimeException.class)
	public ResponseModel<?> excecao(RuntimeException i){
		return new ResponseModel<>("Error",i.getMessage(),null);
	}
	
}
