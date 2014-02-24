package org.github.marcellodesales.staticreference;

import static java.util.Arrays.asList;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Demonstration of static method references and constructor method references.
 *
 * @author Edwin Dalorzo
 */
public class StaticMethodReferenceSyntaxCreation {

  static class IntPredicates {
    public static boolean isOdd(Integer n) {
      return n % 2 != 0;
    }

    public static boolean isEven(Integer n) {
      return n % 2 == 0;
    }

    public static boolean isPositive(Integer n) {
      return n >= 0;
    }
  }

  public static void main(String[] args) {
    List<Integer> numbers = asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
    System.out.println("ALL: " + numbers);

    List<Integer> odds = filter(IntPredicates::isOdd, numbers);
    System.out.println("ODDs: " + odds);

    List<Integer> evens = filter(IntPredicates::isEven, numbers);
    System.out.println("EVENs: " + evens);
  }

  // from demo 1
  static <T> List<T> filter(Predicate<T> predicate, List<T> source) {
    List<T> destiny = new ArrayList<>();
    for (T item : source) {
      if (predicate.test(item)) {
        destiny.add(item);
      }
    }
    return destiny;
  }

}
