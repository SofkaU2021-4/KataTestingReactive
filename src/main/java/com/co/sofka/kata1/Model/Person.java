package com.co.sofka.kata1.Model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("persona")
public class Person {

    @Id
    private String id;
    private String name;

    public Person(String name) {
        this.name = name;
    }

    public Person() {
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}

