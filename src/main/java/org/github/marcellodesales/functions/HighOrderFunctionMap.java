package org.github.marcellodesales.functions;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import org.github.marcellodesales.Jedi;

/**
 * This demo illustrates the creation of a high order function called map and the use of lambda expressions to implement
 * a Function functional interface.
 *
 * @author Edwin Dalorzo
 */
public class HighOrderFunctionMap {
  public static void main(String[] args) {

    List<Integer> numbers = asList(1, 2, 3, 4, 5);
    List<Integer> squares = map(n -> n * n, numbers);
    System.out.println(squares);
    // [1, 4, 9, 16, 25]

    List<String> digits = asList("1", "2", "3", "4", "5");
    List<Integer> integers = map(s -> new Integer(s), digits);
    System.out.println(integers);
    // [1, 2, 3, 4, 5]

    List<String> names = asList("Pedro", "Juan", "Mariana");
    List<Integer> sizes = map(name -> name.length(), names);
    System.out.println(sizes);
    // [5, 4, 7]

    List<Jedi> jedis = asList(new Jedi("Yoda", 500), new Jedi("Anakin", 25), new Jedi("Obi-wan", 80));
    List<String> jediNames = map(j -> j.getName(), jedis);
    System.out.println(jediNames);
    // [Yoda, Anakin, Obi-wan]

    List<Integer> jediPower = map(j -> j.getPower(), jedis);
    System.out.println(jediPower);
    // [500, 25, 80]

  }

  interface Function<T, R> {
    R apply(T t);
  }

  static <T, R> List<R> map(Function<T, R> function, List<T> source) {
    List<R> destiny = new ArrayList<>();
    for (T item : source) {
      R value = function.apply(item);
      destiny.add(value);
    }
    return destiny;
  }

}
