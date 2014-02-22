package org.github.marcellodesales.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.github.marcellodesales.Person;

public class StreamBulkOperationsWithPOJOs {

  public static void main(String[] args) {

    List<Person> list = Arrays.asList(
        new Person("MarceLLo", "de Sales"),
        new Person("Thiago", "de Sales"),
        new Person("Leandro", "de Sales"),
        new Person("Livia", "Maria"));

    // grouping
    System.out.println(
        list.stream()
          .filter(p -> p.getFirstName().contains("L"))
          .collect(Collectors.groupingBy(Person::getLastName)));

  }

}
