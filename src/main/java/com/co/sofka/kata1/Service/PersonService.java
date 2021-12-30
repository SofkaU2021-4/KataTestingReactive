package com.co.sofka.kata1.Service;


import com.co.sofka.kata1.Model.Person;
import com.co.sofka.kata1.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.function.BiFunction;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Flux<Person> listAll(){
        return personRepository.findAll();
    }

    public Mono<Void> insert(Person person) {
        return validateBeforeInsert.apply(personRepository,person)
                .switchIfEmpty(Mono.defer(() -> personRepository.save(person)))
               // .flatMap(personRepository::save)
                .then();

    }

    private final BiFunction<PersonRepository, Person, Mono<Person>> validateBeforeInsert
            = (repo, person) -> repo.findByName(person.getName());

}
