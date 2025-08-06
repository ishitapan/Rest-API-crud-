package com.example.demo.mapper;

import com.example.demo.dto.PersonDto;
import com.example.demo.model.Person;

public class PersonMapper {
    // Converts Entity to DTO for API response
    public static PersonDto mapToPersonDto(Person person){
        return new PersonDto(
                person.getId(),
                person.getFname(),
                person.getLname(),
                person.getEmail()
        );
    }
    // Converts DTO to Entity for saving in database
    public static Person mapToPerson(PersonDto personDto){
        return new Person(
                personDto.getId(),
                personDto.getFname(),
                personDto.getLname(),
                personDto.getEmail()
        );
    }
}
