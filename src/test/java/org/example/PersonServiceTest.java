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
    IPersonService service;

    @BeforeEach
    void setup() {
        service = new PersonService();

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
    void testCreatePerson_WhenSuccess_ShouldReturnPersonObject() throws IllegalAccessException {
        //Given

        //When
        Person actual = service.createPerson(person);

        //Then
        assertNotNull(actual, () -> "The createPerson() should not have returned null!");
    }

    @DisplayName("When Create a Person with Success Should Contains Valid Fields in Return a Person Object")
    @Test
    void testCreatePerson_WhenSuccess_ShouldContainsValidFieldsInReturnPersonObject() throws IllegalAccessException {
        //Given

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

    @DisplayName("When Create a Person with null email Should throw Exception")
    @Test
    void testCreatePerson_WithNullEmail_ShouldThrowIllegalArgumentException() {
        //Given
        person.setEmail(null);

        var expectedMessage = "The Person email is null or empty";

        //When / then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> service.createPerson(person),
                () -> "Empty email should have cause an IllegalArgumentException"
        );

        //then
        assertEquals(expectedMessage, exception.getMessage(), () -> "Exception error message is incorrect");
    }
}
