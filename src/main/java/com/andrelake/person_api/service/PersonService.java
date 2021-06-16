package com.andrelake.person_api.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.andrelake.person_api.dto.req.PersonDTO;
import com.andrelake.person_api.dto.res.MessageResponseDTO;
import com.andrelake.person_api.exception.PersonNotFoundException;
import com.andrelake.person_api.mapper.PersonMapper;
import com.andrelake.person_api.model.Person;
import com.andrelake.person_api.repo.PersonRepository;

@Service
public class PersonService {
	
	@Autowired
	private PersonRepository repository;
	
	@Autowired
	private PersonMapper mapper;
	
	public List<PersonDTO> findAll() {
		
		List<Person> allpeople = repository.findAll();
		
		return allpeople.stream()
				.map(mapper::toDTO)
				.collect(Collectors.toList());
	}
	
	public MessageResponseDTO createPerson(PersonDTO personDTO) {
		
		Person personToSave = mapper.toModel(personDTO);
		Person savedPerson = repository.save(personToSave);
		
		return createMessageResponse(savedPerson.getId(),
				"Person created with ID ");
	}
	
	public PersonDTO findById(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		
		return mapper.toDTO(person);
	}
	
	public MessageResponseDTO updatePersonById(Long id, PersonDTO personDTO) throws PersonNotFoundException {
		
		verifyIfExists(id);
		
		Person personToUpdate = mapper.toModel(personDTO);
		Person updatedPerson = repository.save(personToUpdate);
		
		return createMessageResponse(updatedPerson.getId(),
				"Person updated with ID ");
	}
	
	public MessageResponseDTO deletePerson(Long id) throws PersonNotFoundException {
		Person person = verifyIfExists(id);
		repository.delete(person);
		
		return createMessageResponse(person.getId(), 
				"Person deleted. ID ");
	}
	
	//utils
	private Person verifyIfExists(Long id) throws PersonNotFoundException {
		return repository.findById(id)
				.orElseThrow(() -> new PersonNotFoundException(id));
	}

	private MessageResponseDTO createMessageResponse(Long id, String message) {
		return MessageResponseDTO
				.builder()
				.message(message + id)
				.build();
	}
}
