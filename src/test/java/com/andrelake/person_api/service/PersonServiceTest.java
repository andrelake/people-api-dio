package com.andrelake.person_api.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

import org.mockito.junit.jupiter.MockitoExtension;

import com.andrelake.person_api.dto.req.PersonDTO;
import com.andrelake.person_api.dto.res.MessageResponseDTO;
import com.andrelake.person_api.model.Person;
import com.andrelake.person_api.repo.PersonRepository;
import com.andrelake.person_api.utils.PersonUtils;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
	
	@Mock
	private PersonRepository personRepo;
	
	@InjectMocks
	private PersonService personServ;
	
	PersonDTO personDTO = PersonUtils.createFakeDTO();
	Person person = PersonUtils.createFakeEntity();
	
	@Test
	void givenDTOShouldReturnSavedMessage() {
		
		Mockito.when(personRepo.save(any(Person.class))).thenReturn(person);
		MessageResponseDTO createPersonMessage = personServ.createPerson(personDTO);
		
		MessageResponseDTO expectedMessage = createExpectedMessageResponse(person.getId());
		
		
		assertEquals(createPersonMessage, expectedMessage);
	}

	
	//utils
	private MessageResponseDTO createExpectedMessageResponse(Long id) {
		return MessageResponseDTO.builder()
				.message("Person created with ID " + id)
				.build();
	}

}
