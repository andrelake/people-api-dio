package com.andrelake.person_api.controller;

import java.util.List;

import javax.validation.Valid;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrelake.person_api.dto.req.PersonDTO;
import com.andrelake.person_api.dto.res.MessageResponseDTO;
import com.andrelake.person_api.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
	private PersonService service;
	
	@Autowired
	public PersonController(PersonService service) {
		this.service = service;
	}


	@GetMapping
	public List<PersonDTO> listAll() {
		
		return service.findAll();
	}
	
	@PostMapping
	public MessageResponseDTO createPerson(@RequestBody @Valid PersonDTO personDTO) {
		
		return service.createPerson(personDTO);
	}
}
