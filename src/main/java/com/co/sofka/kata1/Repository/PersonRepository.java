package com.co.sofka.kata1.Repository;

import com.co.sofka.kata1.Model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PersonRepository extends ReactiveMongoRepository<Person,String> {
}
