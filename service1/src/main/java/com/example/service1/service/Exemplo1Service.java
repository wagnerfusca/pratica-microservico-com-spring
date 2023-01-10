package com.example.service1.service;

import org.springframework.stereotype.Service;

import com.example.service1.dto.CalculadoraDto;

@Service
public class Exemplo1Service {

	public String metodoExemplo() {
		return "chegou ao metodo exemplo";
	}
	
	public Integer somar(CalculadoraDto calculadora) {
		return calculadora.getValor1() + calculadora.getValor2();
	}
}
