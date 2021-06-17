package com.andrelake.person_api.utils;

import java.time.LocalDate;
import java.util.Collections;

import com.andrelake.person_api.dto.req.PersonDTO;
import com.andrelake.person_api.model.Person;

public class PersonUtils {

	private static final String FIRSTNAME = "Marcos";
	private static final String LASTNAME = "Pereira";
	private static final String CPF = "369.333.878-79";
	private static final Long PERSONID = 1L;
	private static final LocalDate BIRTHDATE = LocalDate.of(2021, 6, 17);
	
	public static PersonDTO createFakeDTO() {
		return PersonDTO.builder()
				.firstName(FIRSTNAME)
				.lastName(LASTNAME)
				.cpf(CPF)
				.birthDate("01-01-2021")
				.phones(Collections.singletonList(PhoneUtils.createFakeDTO()))
				.build();
	}
	
	public static Person createFakeEntity() {
		return Person.builder()
				.id(PERSONID)
				.firstName(FIRSTNAME)
				.lastName(LASTNAME)
				.cpf(CPF)
				.birthDate(BIRTHDATE)
				.phones(Collections.singletonList(PhoneUtils.createFakeEntity()))
				.build();
	}
	
	
}
