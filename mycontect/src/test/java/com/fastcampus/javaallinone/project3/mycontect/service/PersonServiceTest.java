package com.fastcampus.javaallinone.project3.mycontect.service;

import com.fastcampus.javaallinone.project3.mycontect.domain.Block;
import com.fastcampus.javaallinone.project3.mycontect.domain.Person;
import com.fastcampus.javaallinone.project3.mycontect.domain.dto.Birthday;
import com.fastcampus.javaallinone.project3.mycontect.repository.BlockRepository;
import com.fastcampus.javaallinone.project3.mycontect.repository.PersonRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@SpringBootTest
public class PersonServiceTest {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;
    @Test
    void getPeopleByName(){
        List<Person> result = personService.getPeopleByName("martin");

        assertThat(result.size()).isEqualTo(1);
        assertThat(result.get(0).getName()).isEqualTo("martin");
    }
    private void givenPerson(String name, int age, String bloodType) {
        givenPerson(name, age, bloodType, null);
    }
    private void givenPerson(String name, int age, String bloodType, LocalDate birthday) {
        Person person = personService.getPerson(3L);
        assertThat(person.getName()).isEqualTo("dennis");
    }
    private void givenBlockPerson(String name, int age, String bloodType){
        Person blockPerson = new Person(name, age, bloodType);
        blockPerson.setBlock(new Block(name));
        personRepository.save(blockPerson);
    }

    private void givenPeople() {
        givenPerson("martin", 10, "A");
        givenPerson("david", 9, "B");
        givenBlockPerson("dennis", 7, "O");
        givenBlockPerson("martin", 10, "AB");
    }

    @Test
    void getPerson(){
        givenPeople();

        Person person = personService.getPerson(3L);

        System.out.println(person);
    }
}
