package org.github.marcellodesales.functions;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;

import org.github.marcellodesales.Jedi;
import org.github.marcellodesales.Person;

/**
 * This demo illustrates the creation of a high order function called filter and the use of lambda expressions to
 * implement a predicate functional interface.
 *
 * @author Edwin Dalorzo
 * @author mdesales (modified)
 */
public class HighOrderFunctionPredicateFunctional {

  public static void main(String[] args) {

    List<Integer> numbers = asList(1, 2, 3, 4, 5);
    List<Integer> odds = filter(n -> n % 2 != 0, numbers);
    System.out.println(odds);

    List<String> things = asList("anna", "engine", "eye", "bone");
    List<String> palindromes = filter(w -> new StringBuilder(w).reverse().toString().equals(w), things);
    System.out.println(palindromes);

    List<Jedi> jedis = asList(new Jedi("Yoda", 500), new Jedi("Anakin", 25), new Jedi("Obi-wan", 80));
    List<Jedi> powefulJedis = filter(j -> j.getPower() > 100, jedis);
    System.out.println(powefulJedis);

    List<Person> people = asList(new Person("Marcello", "Alves de Sales Junior"),
        new Person("Leandro", "Melo de Sales"), new Person("Thiago", "Melo de Sales"));
    List<Person> onlyDeMelos = filter(person -> person.getLastName().endsWith("de Sales"), people);
    System.out.println(onlyDeMelos);
  }

  public interface Predicate<T> {
    public boolean test(T t);
  }

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
