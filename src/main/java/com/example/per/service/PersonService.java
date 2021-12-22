package com.example.per.service;

import com.example.per.entity.Person;

import java.util.List;

public interface PersonService {
    Person savePerson(Person person);
    void deleteById(Long id);
    Person getById(Long id);
    List<Person> getAll(String info);

}
