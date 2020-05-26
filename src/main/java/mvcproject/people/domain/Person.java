package mvcproject.people.domain;

import lombok.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

//@RequiredArgsConstructor
//@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private int length;
    private int weight;
    private String motto;

    public Person() {
    }

    public Person(String firstName, String lastName, int age, int length, int weight, String motto) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.length = length;
        this.weight = weight;
        this.motto = motto;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }
}

