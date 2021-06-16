package com.andrelake.person_api.controller;

import java.util.List;

import javax.validation.Valid;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.andrelake.person_api.dto.req.PersonDTO;
import com.andrelake.person_api.dto.res.MessageResponseDTO;
import com.andrelake.person_api.exception.PersonNotFoundException;
import com.andrelake.person_api.service.PersonService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonController {
	
	private PersonService service;
	
	@GetMapping
	public List<PersonDTO> listAll() {
		
		return service.findAll();
	}
	
	@GetMapping("/{id}")
	public PersonDTO findById(@PathVariable Long id) throws PersonNotFoundException {
		
		return service.findById(id);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		
		return service.createPerson(personDTO);
	}
	
	@PutMapping("/{id}")
	public MessageResponseDTO updatePersonById(@PathVariable Long id, @RequestBody PersonDTO personDTO) throws PersonNotFoundException {
		
		return service.updatePersonById(id, personDTO);
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public MessageResponseDTO deletePerson(@PathVariable Long id) throws PersonNotFoundException {
		
		return service.deletePerson(id);
	}
}
