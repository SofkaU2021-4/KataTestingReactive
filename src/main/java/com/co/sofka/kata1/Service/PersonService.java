package com.co.sofka.kata1.Service;


import com.co.sofka.kata1.Model.Person;
import com.co.sofka.kata1.Repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public Flux<Person> listAll(){
        return personRepository.findAll();
    }

}
