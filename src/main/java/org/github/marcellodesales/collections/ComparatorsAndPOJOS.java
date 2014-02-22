package org.github.marcellodesales.collections;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import org.github.marcellodesales.Person;

public class ComparatorsAndPOJOS {

  public static void main(String[] args) {

    List<Person> people = Arrays.asList(
        new Person("Marcello", "De Sales"),
        new Person("Leandro", "Melo"),
        new Person("Thiago", "Bruno"));

    // be careful, as this comparison is case sensitive
    people.sort(Comparator.comparing((Person p) -> p.getLastName()));

    System.out.println(people);

    List<Person> people2 = Arrays.asList(
        new Person("Marcello", "de Sales"),
        new Person("Leandro", "Melo"),
        new Person("Thiago", "bruno"));

    // be careful, as this comparison is case sensitive.. Melo < bruno < de Sales
    people2.sort(Comparator.comparing((Person p) -> p.getLastName()));

    System.out.println(people2);
  }
}
