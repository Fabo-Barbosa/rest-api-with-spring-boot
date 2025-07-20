package br.com.fabodev.controller;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabodev.exceptions.UnsupportedMathOperationException;
import br.com.fabodev.mathaux.NumberTratamentAuxiliar;
import br.com.fabodev.mathaux.OperationResult;

@RestController
public class MathController {
	
	private final AtomicLong count = new AtomicLong();
	OperationResult mat = new OperationResult();
	
	@GetMapping(value = "/sum/{valueOne}/{valueTwo}")
	public double sum(
			@PathVariable(value = "valueOne") String valor1,
			@PathVariable(value = "valueTwo") String valor2
			) throws Exception {
		
		return mat.getSum(valor1, valor2);
	}
	
	@GetMapping(value = "/sub/{valueOne}/{valueTwo}")
	public double sub(
			@PathVariable(value = "valueOne") String valor1,
			@PathVariable(value = "valueTwo") String valor2
			) throws Exception {
		
		return mat.getSub(valor1, valor2);
	}
	
	@GetMapping(value = "/div/{valueOne}/{valueTwo}")
	public double div(
			@PathVariable(value = "valueOne") String valor1,
			@PathVariable(value = "valueTwo") String valor2
			) throws Exception {
		
		return mat.getDiv(valor1, valor2);
	}
	
	@GetMapping(value = "/mult/{valueOne}/{valueTwo}")
	public double mult(
			@PathVariable(value = "valueOne") String valor1,
			@PathVariable(value = "valueTwo") String valor2
			) throws Exception {
		
		return mat.getMult(valor1, valor2);
	}
	
	@GetMapping(value = "/media/{valueOne}/{valueTwo}")
	public double media(
			@PathVariable(value = "valueOne") String valor1,
			@PathVariable(value = "valueTwo") String valor2
			) throws Exception {
		
		return mat.getMedia(valor1, valor2);
	}
	
	@GetMapping(value = "/sqrt/{value}")
	public double sqrt(
			@PathVariable(value = "value") String valor
			) throws Exception {
		
		return mat.getSqrt(valor);
	}

}
