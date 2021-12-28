package com.co.sofka.kata1.Controllers;


import com.co.sofka.kata1.Model.Person;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/person")
public class PersonController {
    @PostMapping
    public Mono<Void> post(@RequestBody Mono<Person> personMono){
        return Mono.empty();
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
        var personas= List.of(
                new Person("Raul Alzate"),
                new Person("Pedro")
        );
        return Flux.fromStream(personas.stream());
    }

    @PutMapping
    public Mono<Void> update(@RequestBody Mono<Person> personMono){
        return Mono.empty();
    }


}
