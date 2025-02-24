package com.expenserestapi.expenseappapi;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
@ComponentScan
public class ExpenseappapiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseappapiApplication.class, args);
	}


	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();// as soon we run it will create object for model mapper
	}
}
