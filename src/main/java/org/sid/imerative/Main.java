package org.sid.imerative;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        // Define a list of people
        List<Person> people = List.of(
                new Person("John", Gender.MALE),
                new Person("Jane", Gender.FEMALE),
                new Person("Jane", Gender.FEMALE),
                new Person("Emily", Gender.FEMALE)
        );
        System.out.println("imperative approach");
        //imperative approach
        // Reverse the list (Collections.reverse() can be used for mutable lists)
        List<Person> reversedPeople = new ArrayList<>(people);
        Collections.reverse(reversedPeople);

        // Print the reversed list
        System.out.println("Reversed List:");
        reversedPeople.forEach(System.out::println);

        // Filter females into a new list
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (Gender.FEMALE.equals(person.gender)) {
                females.add(person);
            }
        }

        for (Person female:females){
            System.out.println("#################################");
            // Print females
            System.out.println("Female List:");
            females.forEach(System.out::println);
            System.out.println("#################################");
        }
        // Filter males into a new list
        List<Person> males = new ArrayList<>();
        for (Person person : people) {
            if (Gender.MALE.equals(person.gender)) {
                females.add(person);
            }
        }
       for (Person male : males)
        // Print males
        System.out.println("Male List:");
         males.forEach(System.out::println);

        System.out.println("declarative approach");
         // declarative approach
        people.stream().filter(person -> Gender.FEMALE.equals(person.gender))
            .collect(Collectors.toList()).forEach(System.out::println);
    }

    // Person class should be outside of the main method
    static class Person {
        private final String name;
        private final Gender gender;

        public Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{name='" + name + "', gender=" + gender + "}";
        }
    }

    // Enum class for Gender
    enum Gender {
        MALE, FEMALE
    }
}
