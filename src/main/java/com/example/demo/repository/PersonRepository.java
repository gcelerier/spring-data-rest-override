package com.example.demo.repository;

import java.util.List;

import com.example.demo.domain.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface PersonRepository extends CrudRepository<Person, Long> {

  List<Person> findByLastName(@Param("name") String name);

}
