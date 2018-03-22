package com.example.demo.service;

import com.example.demo.domain.Person;
import com.example.demo.repository.PersonRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

  private final PersonRepository personRepository;

  private static final Logger LOGGER = LoggerFactory.getLogger(PersonService.class);

  @Autowired
  public PersonService(PersonRepository personRepository) {
    this.personRepository = personRepository;
  }

  public Person savePerson(Person person) {
    LOGGER.info("I am doing some additional stuff!");
    return personRepository.save(person);
  }

  public Person getPerson(Long personId) {
    return personRepository.findOne(personId);
  }
}
