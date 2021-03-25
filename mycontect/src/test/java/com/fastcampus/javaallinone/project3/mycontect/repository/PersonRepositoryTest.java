package com.fastcampus.javaallinone.project3.mycontect.repository;

import com.fastcampus.javaallinone.project3.mycontect.domain.Block;
import com.fastcampus.javaallinone.project3.mycontect.domain.Person;
import com.fastcampus.javaallinone.project3.mycontect.domain.dto.Birthday;
import com.fastcampus.javaallinone.project3.mycontect.service.PersonService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PersonRepositoryTest {
    @Autowired
    private PersonRepository personRepository;
    @Autowired
    private PersonService personService;

    @Test
    void crud() {
        Person person = new Person();
        person.setName("martin");
        person.setAge(10);
        person.setBloodType("A");
        personRepository.save(person);

        List<Person> people = personRepository.findAll();
        Assert.isTrue(people.size() == 1, "IdError");
        Assert.isTrue(people.get(0).getName() == "martin", "NameError");
        Assert.isTrue(people.get(0).getAge() == 10, "AgeError");
    }

    @Test
    void hashCodeAndEquals() {
        Person person1 = new Person("martin", 10, "A");
        Person person2 = new Person("martin", 10, "A");

        System.out.println(person1.equals(person2));
        System.out.println(person1.hashCode());
        System.out.println(person2.hashCode());

        Map<Person, Integer> map = new HashMap<>();
        map.put(person1, person1.getAge());

        System.out.println(map);
        System.out.println(map.get(person2));
    }
    @Test
    void findByBirthdayBetween(){
        givenPerson("martin", 10, "A", LocalDate.of(1991, 8, 15));
        givenPerson("david", 9, "B", LocalDate.of(1992, 7, 15));
        givenPerson("dennis", 8, "O", LocalDate.of(1993, 6, 15));
        givenPerson("sophia", 7, "AB", LocalDate.of(1994, 5, 15));
        givenPerson("benny", 5, "A", LocalDate.of(1995, 8, 15));

        List<Person> result = personRepository.findByMonthOfBirthday(8);
    }
    private void givenPerson(String name, int age, String bloodType) {
        givenPerson(name, age, bloodType, null);
    }
    private void givenPerson(String name, int age, String bloodType, LocalDate birthday) {
        Person person = personRepository.save(new Person(name, age, bloodType));
        person.setBirthday(new Birthday(birthday.getYear(), birthday.getMonthValue(), birthday.getDayOfMonth()));
        personRepository.save(person);
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