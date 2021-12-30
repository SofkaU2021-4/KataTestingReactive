package com.co.sofka.kata1.Repository;

import com.co.sofka.kata1.Model.Person;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Mono;

public interface PersonRepository extends ReactiveMongoRepository<Person,String> {
    Mono<Person> findByName(String name);
}
