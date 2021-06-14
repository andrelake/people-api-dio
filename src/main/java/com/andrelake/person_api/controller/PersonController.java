package com.andrelake.person_api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.andrelake.person_api.dto.req.PersonDTO;
import com.andrelake.person_api.service.PersonService;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {
	
//	@Autowired
//	private PersonService service;
//
	@GetMapping
	public String listAll() {
		return "API test";

	}
}
