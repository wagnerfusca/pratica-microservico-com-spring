package com.example.service2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.service2.dto.CalculadoraDto;

@RestController
@RequestMapping("/servico2")
public class Service2Controller {

	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping
	public ResponseEntity<Object> metodoGet(){
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("entrou no metodo get");
	}
	
	@GetMapping("/acessarservico1")
	public void acessarMicroServico1() {
		var retorno = restTemplate.exchange("http://service1/microservico1/retorna", HttpMethod.GET, null, String.class);
		System.out.println(retorno);
	}
	
	@GetMapping("/somar")
	public void somar() {
		CalculadoraDto dto = new CalculadoraDto();
		dto.setValor1(32);
		dto.setValor2(5);
		
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<?> httpEntity = new HttpEntity<Object>(dto, headers);
		
		var retorno = restTemplate.exchange("http://service1/microservico1", HttpMethod.POST, httpEntity, Integer.class);
		System.out.println(retorno);		
		
	}
	
}
