package com.example.service1.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.service1.dto.CalculadoraDto;
import com.example.service1.service.Exemplo1Service;

@RestController
@RequestMapping("/microservico1")
public class ExemploController {

	@Autowired
	Exemplo1Service exemplo1Service;
	
	@GetMapping("/retorna")
	public ResponseEntity<Object> metodoGet(){
		return ResponseEntity.status(HttpStatus.ACCEPTED)
				.body(exemplo1Service.metodoExemplo());
	}
	
	@PostMapping
	public ResponseEntity<Object> metodoPost(@RequestBody CalculadoraDto dto){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(exemplo1Service.somar(dto));
		
	}
	
	
	
	
	
	
}
