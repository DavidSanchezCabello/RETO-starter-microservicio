package com.dscode.aplication.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.micrometer.core.instrument.Counter;


@RestController
public class IndexController {

	@Autowired
	private Convertir convertir;
	
	private Counter contadorCel;
	private Counter contadorFar;
	
	private final static Logger logger = LoggerFactory.getLogger(IndexController.class);
	
	public IndexController() {
		
	}
	
	@GetMapping("/celAfar")
	public ResponseEntity<String> index() {
		return new ResponseEntity<String>(HttpStatus.OK).ok(convertir.mensajeConversion());
	}
	
	@GetMapping("/farAcel")
	public ResponseEntity<String> saludo(@RequestParam("status") String status) {
		logger.info("Realizamos una operación " + );
		return new ResponseEntity<String>(HttpStatus.OK).ok("Todo ha salido Okey");
	}
}
