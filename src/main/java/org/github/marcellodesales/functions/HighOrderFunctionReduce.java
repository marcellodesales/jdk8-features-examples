package org.github.marcellodesales.functions;

import static java.util.Arrays.asList;

import java.util.List;

import org.github.marcellodesales.Jedi;

/**
 * This demo illustrates the creation of a high order function called reduce and the use of lambda expressions to
 * implement a BinaryOperator functional interface.
 *
 * @author Edwin Dalorzo
 */
public class HighOrderFunctionReduce {
  public static void main(String[] args) {

    List<Integer> numbers = asList(1, 2, 3, 4, 5);

    Integer sum = reduce((x, y) -> x + y, 0, numbers);
    System.out.println(sum);

    List<String> animals = asList("cat", "Hourse", "dog", "bird");
    String allAnimals = reduce((String a1, String a2) -> a1 + " " + a2, "", animals).trim();
    System.out.println(allAnimals);

    String biggerName = reduce((a, b) -> a.length() > b.length() ? a : b, "", animals);
    System.out.println(biggerName);

    List<Jedi> jedis = asList(
        new Jedi("Yoda", 500),
        new Jedi("Anakin", 25),
        new Jedi("Obi-wan", 80));
    Jedi mostPowerfulJedi = reduce((j1, j2) -> j1.getPower() > j2.getPower() ? j1 : j2, new Jedi("Nobody", 0), jedis);

    System.out.println(mostPowerfulJedi);
  }

  interface BinaryOperator<T> {
    T apply(T left, T right);
  }

  static <T> T reduce(BinaryOperator<T> operator, T seed, List<T> source) {
    for (T item : source) {
      seed = operator.apply(seed, item);
    }
    return seed;
  }

}
