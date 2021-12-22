package com.example.per.dao;

import com.example.per.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PersonDao extends JpaRepository<Person,Long> {
}
