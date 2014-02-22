package org.github.marcellodesales.streams;

import java.util.Arrays;

public class StringBulkOperationsMapReduce {

  public static void main(String[] args) {

    // reduce
    System.out.println(
        Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9).stream()
          .filter(a -> a % 2 == 0)
          .map(a -> a * a)
          .reduce((a, b) -> a + b).get());
  }

}
