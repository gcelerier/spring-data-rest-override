package com.example.demo.controller;

import com.example.demo.domain.Person;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.hateoas.EntityLinks;
import org.springframework.hateoas.LinkBuilder;
import org.springframework.hateoas.Resource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@RepositoryRestController
public class PersonController {

  private final PersonService personService;

  private final EntityLinks entityLinks;

  @Autowired
  public PersonController(PersonService personService, EntityLinks entityLinks) {
    this.personService = personService;
    this.entityLinks = entityLinks;
  }

  @RequestMapping(path = "/persons", method = RequestMethod.POST)
  public @ResponseBody  Resource<Person> savePerson(@RequestBody Person person) {
    Person savedPerson = personService.savePerson(person);
    return createPersonResource(savedPerson);
  }

  private Resource<Person> createPersonResource(Person person) {
    Resource<Person> personResource = new Resource<>(person);

    LinkBuilder linkBuilder = entityLinks.linkForSingleResource(Person.class, person.getId());
    personResource.add(linkBuilder.withSelfRel());
    personResource.add(linkBuilder.withRel("person"));

    return personResource;
  }
}
