package org.github.marcellodesales.lambda;

import java.util.Comparator;
import java.util.concurrent.Callable;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * Summary of different lambda expression syntax.
 *
 * @author Edwin Dalorzo
 */
public class LambdaExpressionsSyntaxSummary {

  public static void main(String[] args) {

    Predicate<Integer> isOdd = n -> n % 2 != 0;

    Function<String, Integer> atoi = s -> Integer.valueOf(s);

    BinaryOperator<Integer> product = (x, y) -> x * y;

    Supplier<String> greet = () -> "Hello World";

    Consumer<String> printer = s -> {
      System.out.println(s);
    };

    Comparator<Integer> cmp = (Integer x, Integer y) -> Integer.compare(x, y);

    Callable<String> farewell = () -> "Good-bye cruel world";

    Runnable task = () -> {
      System.out.println("Hello Lambdanians!");
    };

    new Thread(() -> {
      System.out.println("Hello Lambdanians!");
    }).start();
  }
}
