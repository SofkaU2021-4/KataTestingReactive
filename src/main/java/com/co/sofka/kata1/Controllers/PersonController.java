package com.co.sofka.kata1.Controllers;


import com.co.sofka.kata1.Model.Person;
import com.co.sofka.kata1.Service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.invoke.SerializedLambda;
import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    PersonService personService;

    @PostMapping
    public Mono<Void> post(@RequestBody Mono<Person> personMono){
        return personMono.flatMap(personService::insert);
    }

    @GetMapping("/{id}")
    public  Mono<Person> getPerson(@PathVariable("id") String id){
        return Mono.just(new Person());
    }

    @DeleteMapping("/{id}")
    public Mono<Void>  delete(@PathVariable ("id") String id){
        return Mono.empty();
    }

    @GetMapping
    public Flux<Person> list(){

        return personService.listAll();
    }

    @PutMapping
    public Mono<Void> update(@RequestBody Mono<Person> personMono){
        return Mono.empty();
    }


}
