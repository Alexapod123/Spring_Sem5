package com.example.sem5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class PersonServiceImpl implements PersonService{
    private final PersonRepository personRepository;

    @Autowired
    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    @Override
    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Not Found"));
    }

    @Override
    public Person createPerson(Person person) {
        return personRepository.save(person);
    }

    @Override
    public Person updatePerson(Long id, Person person) {
        Person existingPerson = getPersonById(id);
        existingPerson.setBirthday(person.getBirthday());
        existingPerson.setName(person.getName());
        existingPerson.setMarried(person.getMarried());
        return personRepository.save(existingPerson);
    }

    @Override
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }
}
