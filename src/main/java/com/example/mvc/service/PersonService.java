package com.example.mvc.service;

import org.springframework.data.domain.Page;

import com.example.mvc.entity.Person;

public interface PersonService {
    Page<Person> findAll(int page, int size);

    Page<Person> findByNameLike(String name, int page, int size);

    Person findPersonById(Integer id);

    void insert(Person person);

    void update(Person person);

    void deleteById(Integer id);

}
