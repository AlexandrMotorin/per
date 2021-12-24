package com.example.per.entity;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "PERSON")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Поле не может быть пустым")
    @Column(name = "FIRST_NAME")
    private String firstName;

    @NotBlank(message = "Поле не может быть пустым")
    @Column(name = "LAST_NAME")
    private String lastName;

    @NotNull
    @Min(1) @Max(90)
    @Column(name = "AGE")
    private int age;

    public Person() {
    }

    public Person(String firstName, String lastName, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
