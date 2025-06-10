package org.example.service;

import org.example.model.Person;

import java.util.concurrent.atomic.AtomicLong;

public class PersonService implements IPersonService {
    @Override
    public Person createPerson(Person person) throws IllegalAccessException {
        if (person.getEmail() == null || person.getEmail().isBlank()) throw new IllegalAccessException("The Person email is null or empty!!!");

        var id = new AtomicLong().incrementAndGet();
        person.setId(id);
        return person;
    }
}
