package com.example.demo.controller;

import com.example.demo.dto.PersonDto;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class PersonController {

    @Autowired
    private PersonService personService;

    @PostMapping("/add")
    public ResponseEntity<PersonDto>  createPerson(@RequestBody  PersonDto personDto){
        PersonDto savePerson = personService.createPerson(personDto);
        return new ResponseEntity<>(savePerson, HttpStatus.CREATED);

    }
    @GetMapping("/person/{id}")
    public ResponseEntity<PersonDto> getPersonById(@PathVariable Long id){
        PersonDto personDto = personService.getById(id);
        return  ResponseEntity.ok(personDto);
    }
    @GetMapping("/persons")
    public  ResponseEntity<List<PersonDto>> getAllPerson(){
       List<PersonDto> personDto = personService.getAllPerson();
       return ResponseEntity.ok(personDto);
    }
    @PutMapping("/update/{id}")
    public ResponseEntity<PersonDto> updatedPerson(@PathVariable Long id,@RequestBody PersonDto personDto){
       PersonDto updatedPerson = personService.updatePerson(id,personDto);
        return ResponseEntity.ok(updatedPerson);
    }
    @DeleteMapping("{id}")
    public ResponseEntity<String> deletePerson(@PathVariable Long id){
        personService.deletePerson(id);
        return ResponseEntity.ok("Person deleted successfully");
    }

}
