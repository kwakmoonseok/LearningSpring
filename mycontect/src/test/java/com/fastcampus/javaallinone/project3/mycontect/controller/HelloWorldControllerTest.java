package com.fastcampus.javaallinone.project3.mycontect.controller;

import com.fastcampus.javaallinone.project3.mycontect.domain.Person;
import com.fastcampus.javaallinone.project3.mycontect.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class HelloWorldControllerTest {
    @Autowired
    private PersonRepository personRepository;

    @Test
    private void crud(){
        Person person = new Person();
        personRepository.save(person);
        System.out.println(personRepository.findAll());
    }
}