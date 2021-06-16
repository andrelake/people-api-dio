package com.andrelake.person_api.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.andrelake.person_api.dto.req.PersonDTO;
import com.andrelake.person_api.model.Person;

@Mapper(componentModel = "spring")
public interface PersonMapper {
	
	@Mapping(target = "birthDate", source = "birthDate", dateFormat = "dd-MM-yyyy")
	Person toModel(PersonDTO personDTO);
	
	PersonDTO toDTO(Person person);
}
