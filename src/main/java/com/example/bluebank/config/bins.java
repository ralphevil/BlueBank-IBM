package com.example.bluebank.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class bins {
	
	@Bean
	public ModelMapper modelmapper() {
		return new ModelMapper();
	}

}
