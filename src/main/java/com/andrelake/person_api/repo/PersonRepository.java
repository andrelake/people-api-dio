package com.andrelake.person_api.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.andrelake.person_api.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
