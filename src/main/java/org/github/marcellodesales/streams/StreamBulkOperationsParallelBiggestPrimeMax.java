package org.github.marcellodesales.streams;

import java.util.Arrays;
import java.util.OptionalInt;

/**
 * Demonstration of parallelism.
 *
 * @author Edwin Dalorzo
 */
public class StreamBulkOperationsParallelBiggestPrimeMax {

  public static void main(String[] args) {

    // In a VM with 4 cores, 3 Fork/Join threads were created to solve the problem in parallel
    // Easy to read if you start running with a debugger.
    OptionalInt maxPrime = Arrays.stream(getNaturalNumbers()).parallel().filter(MathFunctions::isPrime).max();

    if (maxPrime.isPresent()) {
      System.out.println(maxPrime.getAsInt());
    }

  }

  public static int[] getNaturalNumbers() {
    int[] nats = new int[1_000_000];
    for (int i = 0; i < nats.length; i++) {
      nats[i] = i;
    }
    return nats;
  }

  private static class MathFunctions {

    public static boolean isPrime(long n) {
      if (n < 2 || n % 2 == 0) {
        return false;
      }

      if (n == 2 || n == 3) {
        return true;
      }

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
