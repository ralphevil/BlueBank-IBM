package com.example.bluebank.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseModel<T> {
	
	private String status;
	private String mensagem;
	private T data;
	
	

}
