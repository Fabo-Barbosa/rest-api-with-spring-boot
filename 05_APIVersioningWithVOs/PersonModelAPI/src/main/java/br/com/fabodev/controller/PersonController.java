package br.com.fabodev.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.fabodev.data.vo.v1.PersonVO;
import br.com.fabodev.data.vo.v2.PersonVOV2;
import br.com.fabodev.services.PersonServices;

@RestController
@RequestMapping(value = "/person")
public class PersonController {
	
	@Autowired
	private PersonServices service;
	
	// Substitui @RequestMapping(method = RequestMethod.GET)
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<PersonVO> findAll(
			) throws Exception {
		
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO getById(
			@PathVariable(value = "id") Long idPerson
			) throws Exception {
		
		return service.getById(idPerson);
	}
	
	@PostMapping( consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO create(
			@RequestBody PersonVO person
			) throws Exception {
		
		return service.create(person);
	}
	
	// Versão com PersonVOV2, necessário atualizar o path para /v2
	@PostMapping(value = "/v2", consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVOV2 create(
			@RequestBody PersonVOV2 person
			) throws Exception {
		
		return service.createV2(person);
	}
	
	@PutMapping(consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public PersonVO update(
			@RequestBody PersonVO person
			) throws Exception {
		
		return service.update(person);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> delete(
			@PathVariable("id") Long id
			) throws Exception {
		
		service.delete(id);
		return ResponseEntity.noContent().build(); // envia o status code 204 para retorno vazio
	}
	
}
