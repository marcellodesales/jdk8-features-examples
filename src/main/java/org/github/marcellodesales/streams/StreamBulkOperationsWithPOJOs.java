package org.github.marcellodesales.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.github.marcellodesales.Person;

public class StreamBulkOperationsWithPOJOs {

  public static void main(String[] args) {

    List<Person> list = Arrays.asList(
        new Person("Marcello", "de Sales"),
        new Person("Thiago", "Bruno"),
        new Person("Leandro", "Melo"),
        new Person("Livia", "Maria"));

    // grouping
    System.out.println(
        list.stream()
          .filter(p -> p.getLastName().length() < 7)
          .collect(Collectors.groupingBy(Person::getFirstName)));

  }

}
