package org.github.marcellodesales.functions;

/**
 * This demo illustrates the use of lazy evaluation through the use of lambda expressions to implement a Supplier
 * functional interface.
 *
 * @author Edwin Dalorzo
 */
public class HighOrderFunctionLazyEvaluationSupplierFunction {

  interface Supplier<T> {
    T get();
  }

  public static Integer generateX() {
    System.out.println("Generating x...");
    return 0;
  }

  public static Integer generateY() {
    System.out.println("Generating y...");
    return 1;
  }

  public static Integer calculate(Supplier<Integer> thunkOfx, Supplier<Integer> thunkOfy) {
    System.out.println("Calculating...");
    int x = thunkOfx.get();
    if (x == 0)
      return 0;
    else return x + thunkOfy.get();
  }

  public static void main(String[] args) {
    calculate(() -> generateX(), () -> generateY());
  }

}
