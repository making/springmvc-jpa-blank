package com.example.mvc.repository.custom;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.example.mvc.entity.Person;

public interface PersonRepositoryCustom {
    Page<Person> findByNameLike(String name, Pageable pageable);
}
