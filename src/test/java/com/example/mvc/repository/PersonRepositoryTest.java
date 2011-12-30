package com.example.mvc.repository;

import static org.junit.Assert.*;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.example.mvc.entity.Person;

@ContextConfiguration(locations = "classpath:test-context.xml")
@RunWith(SpringJUnit4ClassRunner.class)
@Transactional
public class PersonRepositoryTest {
    @Inject
    PersonRepository personRepository;

    @Before
    public void setUp() {
        personRepository.deleteAll();
        for (int i = 1; i <= 20; i++) {
            Person p = new Person();
            p.setAge(i % 100);
            p.setName("name" + i);
            personRepository.save(p);
        }
        personRepository.flush();
    }

    @Test
    public void testCount() {
        assertEquals(20, personRepository.count());
    }

    @Test
    public void testFindByName() {
        Page<Person> p = personRepository.findByNameLike("%name1%", new PageRequest(
                0, 5));
        System.out.println(p.getContent());
        assertNotNull(p);
        assertEquals(5, p.getNumberOfElements());
        assertEquals(0, p.getNumber());
        assertEquals(5, p.getSize());
        assertEquals(3, p.getTotalPages());
        assertEquals(11, p.getTotalElements());
    }

}
