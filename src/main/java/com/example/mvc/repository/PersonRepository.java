package com.example.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.mvc.entity.Person;
import com.example.mvc.repository.custom.PersonRepositoryCustom;

public interface PersonRepository extends JpaRepository<Person, Integer>,
        PersonRepositoryCustom {
}
