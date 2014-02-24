package org.github.marcellodesales.functions;

import static java.util.Arrays.asList;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.github.marcellodesales.Jedi;

/**
 * This demo illustrates the creation of a high order function called forEach and the use of lambda expressions to
 * implement a Consumer functional interface.
 *
 * @author Edwin Dalorzo
 */
public class HighOrderFunctionForEach {

  public static void main(String[] args) {
    List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

    forEach((Integer n) -> {
      System.out.println(n);
    }, numbers);

    Set<Jedi> jediSet = new HashSet<>();

    List<Jedi> jedis = asList(
        new Jedi("Yoda", 500),
        new Jedi("Anakin", 25),
        new Jedi("Obi-wan", 80));

    forEach(j -> {
      jediSet.add(j);
    }, jedis);

    System.out.println(jediSet);
  }

  interface Consumer<T> {
    void accept(T t);
  }

  static <T> void forEach(Consumer<T> consumer, List<T> source) {
    for (T item : source) {
      consumer.accept(item);
    }
  }
}
