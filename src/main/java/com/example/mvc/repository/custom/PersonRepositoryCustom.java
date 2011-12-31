package com.example.mvc.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;

import com.example.mvc.entity.Person;

public interface PersonRepositoryCustom {
    @Query("SELECT p FROM Person p WHERE name LIKE ?1")
    Page<Person> findByNameLike(String name, Pageable pageable);
}
