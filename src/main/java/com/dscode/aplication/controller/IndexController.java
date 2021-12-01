package com.dscode.aplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import starter.Convertir;


@RestController
public class IndexController {

	@Autowired
	private Convertir convertir;
	
	private Counter contadorFar;
	
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	public IndexController(MeterRegistry meterRegistry) {
		this.contadorFar=Counter.builder("Invocaciones mas usadas").description("Total de invocaciones para Grados").register(meterRegistry);
	}
	
	
	@GetMapping("/conversor/{status}")
	public ResponseEntity<String> index(@PathVariable("status") String status) {
		contadorFar.increment();
		logger.info("Realizamos una operación " + contadorFar.count());
		return new ResponseEntity<String>(HttpStatus.OK).ok(convertir.mensajeConversion(status));
	}
	
	@GetMapping("/conversor1/{status}")
	public String prueba(@PathVariable("status") String status) {
		contadorFar.increment();
		logger.info("Realizamos una operación " + contadorFar.count());
		return status;
	}
	
}
