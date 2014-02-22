package org.github.marcellodesales.staticreference;

import java.util.Arrays;

public class StaticMethodReference {

  public static void main(String[] args) {

    // jdk7
    for (Integer number : Arrays.asList(1, 2, 3, 4))
      System.out.println(number);

    // jdk8
    // lambdas
    Arrays.asList(1, 2, 3, 4).forEach(value -> System.out.println(value));
    // closures
    Arrays.asList(1, 2, 3, 4).forEach(System.out::println);

  }
}
