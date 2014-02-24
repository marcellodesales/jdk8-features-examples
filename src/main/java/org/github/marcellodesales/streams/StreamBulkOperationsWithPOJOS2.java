package org.github.marcellodesales.streams;

import static java.util.Arrays.asList;

import java.util.Arrays;
import java.util.List;
import java.util.OptionalInt;
import java.util.function.Function;
import java.util.stream.IntStream;

import org.github.marcellodesales.Jedi;

/**
 * Demonstration of the new streams API. Cover laziness and short-circuiting.
 *
 * @author Edwin Dalorzo
 */
public class StreamBulkOperationsWithPOJOS2 {

  public static void main(String[] args) {

    List<Jedi> jedis = asList(new Jedi("Yoda", 500), new Jedi("Anakin", 25), new Jedi("Obi-wan", 80));

    jedis.stream().map(Jedi::getName).forEach(System.out::println);

    int sumOfPowers = jedis.stream().filter(j -> j.getPower() > 100).map((Function<Jedi, Integer>) Jedi::getPower)
        .reduce(0, (x, y) -> x + y);

    IntStream naturals = Arrays.stream(getNaturalNumbers());

    // lazy evaluation
    IntStream primes = naturals.filter(Math::isPrime);

    // short-circuiting
    OptionalInt maxPrime = primes.limit(100).max();

    if (maxPrime.isPresent()) {
      System.out.println(maxPrime.getAsInt());
    }
  }

  public static int[] getNaturalNumbers() {
    int[] nats = new int[19_999_999];
    for (int i = 0; i < nats.length; i++) {
      nats[i] = i;
    }
    return nats;
  }

  private static class Math {

    public static boolean isPrime(long n) {
      if (n < 2)
        return false;
      if (n == 2)
        return true;
      if (n % 2 == 0)
        return false;
      if (n == 3)
        return true;
      long divisor = 3;
      while (true) {
        if (n % divisor == 0)
          return false;
        else if (divisor * divisor > n)
          return true;
        else divisor = divisor + 2;
      }
    }

  }
}
