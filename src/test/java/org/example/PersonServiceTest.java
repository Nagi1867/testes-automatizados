package org.example;

import org.example.model.Person;
import org.example.service.IPersonService;
import org.example.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonServiceTest {
    Person person;

    @BeforeEach
    void setup() {
        person = new Person(
                "Keith",
                "Moon",
                "kmoon@gmail.com",
                "Wembley - US",
                "Male"
        );
    }

    @DisplayName("When Create a Person with Success Should Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() {
        //Given
        IPersonService service = new PersonService();

        //When
        Person actual = service.createPerson(person);

        //Then
        assertNotNull(actual, () -> "The createPerson() should not have returned null!");
    }

    @DisplayName("When Create a Person with Success Should Contains Valid Fields in Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsValidFieldsInReturnPersonObject() {
        //Given
        IPersonService service = new PersonService();

        //When
        Person actual = service.createPerson(person);

        //Then
        assertNotNull(person.getId(), () -> "Person Id is Missing");
        assertEquals(person.getFirstName(), actual.getFirstName(), () -> "The First Name is different");
        assertEquals(person.getLastName(), actual.getLastName(), () -> "The Last Name is different");
        assertEquals(person.getAddress(), actual.getAddress(), () -> "The Address is different");
        assertEquals(person.getGender(), actual.getGender(), () -> "The Gender is different");
        assertEquals(person.getEmail(), actual.getEmail(), () -> "The Email is different");
    }
}
