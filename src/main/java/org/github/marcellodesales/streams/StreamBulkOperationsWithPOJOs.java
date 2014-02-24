package org.github.marcellodesales.streams;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.github.marcellodesales.Person;

/**
 * Documentation at http://www.slideshare.net/martyhall/java-8-tutorial-streams-part-1
 * 
 * @author Marcello de Sales (mdesales)
 *
 */
public class StreamBulkOperationsWithPOJOs {

  public static List<Person> getBrothers() {
    return Arrays.asList(
        new Person("MarceLLo", "de Sales"),
        new Person("Thiago", "de Sales"),
        new Person("Leandro", "de Sales"),
        new Person("Livia", "Maria"));
  }

  public static Stream<Person> personsStream(List<Person> persons) {
    return persons.stream();
  }

  public static Stream<Person> brothersStream() {
    return personsStream(getBrothers());
  }

  public static void main(String[] args) {

    List<Person> list = getBrothers();
    // grouping
    System.out.println(list.stream().filter(p -> p.getFirstName().contains("L"))
        .collect(Collectors.groupingBy(Person::getLastName)));

    System.out.println();

    // using the static reference on foreach
    list.stream().peek(p -> p.setFirstName(p.getFirstName().toUpperCase())).forEach(System.out::println);

    System.out.println();

    // using the reference of consumers to be reusable
    Consumer<Person> changeLastName = p -> p.setLastName(p.getLastName().toLowerCase());
    list.stream().peek(changeLastName).forEach(System.out::println);

    System.out.println();

    Stream<Person> personStream = list.stream();
    try {
      System.out.println("Streams can only be used once");
      personStream.forEach(System.out::println);

      System.out.println("This will throw an exception");
      personStream.forEach(System.out::println);

    } catch (Exception e) {
      System.out.println();
      System.out.println("Streams can't be reused: " + e.getMessage());
    }

    // more reusable to use a factory of streams and separate them
    System.out.println();
    brothersStream().forEach(System.out::println);

    System.out.println("Reusing both predicate and consumer");
    Predicate<Person> nameIsLong = p -> p.getFirstName().startsWith("M");
    brothersStream().filter(nameIsLong).peek(changeLastName).forEach(System.out::println);
  }

}
