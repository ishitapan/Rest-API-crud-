package com.example.demo.service;

import com.example.demo.dto.PersonDto;

import java.util.List;

public interface PersonService {
    PersonDto createPerson(PersonDto personDto);
    PersonDto getById(Long id);
    List<PersonDto> getAllPerson();
    PersonDto updatePerson(Long id,PersonDto personDto);
    void deletePerson(Long id);
}
