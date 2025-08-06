package com.example.demo.service;

import com.example.demo.dto.PersonDto;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.PersonMapper;
import com.example.demo.model.Person;
import com.example.demo.repository.PersonRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PersonServiceImpl implements PersonService{

    private PersonRepo personRepo;

    @Override
    public PersonDto createPerson(PersonDto personDto) {
        Person person = PersonMapper.mapToPerson(personDto);
        Person savePerson = personRepo.save(person);
        return PersonMapper.mapToPersonDto(savePerson);
    }

    @Override
    public PersonDto getById(Long id) {
       Person person = personRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Person id not exist"+id));
        return  PersonMapper.mapToPersonDto(person);
    }

    @Override
    public List<PersonDto> getAllPerson() {
       List<Person>  person = personRepo.findAll();
        return person.stream().map((persons)->PersonMapper.mapToPersonDto(persons)).collect(Collectors.toList());
    }

    @Override
    public PersonDto updatePerson(Long id,PersonDto updatedPerson) {
        Person person = personRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Person is not exist"+id));

        person.setFname(updatedPerson.getFname());
        person.setLname(updatedPerson.getLname());
        person.setEmail(updatedPerson.getEmail());

       Person savedPerson = personRepo.save(person);

        return PersonMapper.mapToPersonDto(person);
    }

    @Override
    public void deletePerson(Long id) {
        Person person = personRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Person is not exists "+id));
        personRepo.deleteById(id);

    }
}
