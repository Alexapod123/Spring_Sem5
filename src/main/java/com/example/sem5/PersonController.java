package com.example.sem5;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/persons")
public class PersonController {
    private final PersonService service;

    @Autowired
    public PersonController(PersonService service) {
        this.service = service;
    }

    @GetMapping
    public List<Person> getAllPersons(){
        return service.getAllPersons();
    }

    @GetMapping("/{id}")
    public Person getPersonById(@PathVariable Long id){
        return service.getPersonById(id);
    }

    @PutMapping("/update/{id}")
    public Person updatePerson(@PathVariable Long id, @RequestBody Person person){
        return service.updatePerson(id, person);
    }

    @PostMapping("/{create}")
    public Person createPerson (@RequestBody Person person){
        return service.createPerson(person);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePerson(@PathVariable Long id){
        service.deletePerson(id);
    }

}
