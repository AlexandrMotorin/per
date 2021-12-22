package com.example.per.service;

import com.example.per.dao.PersonDao;
import com.example.per.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PersonServiceImpl implements PersonService {

    private final PersonDao personDao;

    @Autowired
    public PersonServiceImpl(PersonDao personDao) {
        this.personDao = personDao;
    }

    public Person getById(Long id){
        return personDao.getById(id);
    }

    public List<Person> getAll(String info){

        List<Person> all = personDao.findAll();
        if(info != null)
           all =  all.stream()
                    .filter(p -> p.getFirstName().startsWith(info) || p.getLastName().startsWith(info))
                    .collect(Collectors.toList());

        return all;
    }

    public Person savePerson(Person person){
        return personDao.save(person);
    }

    public void deleteById(Long id){
        personDao.deleteById(id);
    }



}
