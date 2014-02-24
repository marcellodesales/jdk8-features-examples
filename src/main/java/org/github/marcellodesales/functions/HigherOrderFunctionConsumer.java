package org.github.marcellodesales.functions;

import java.util.List;
import java.util.function.Consumer;

import static java.util.Arrays.asList;

/**
 * Demonstration of instance method references to a specific object.
 *
 * @author Edwin Dalorzo
 */
public class HigherOrderFunctionConsumer {

    public static void main(String[] args) {
        List<Integer> numbers = asList(1,2,3,4,5,6,7,8,9);

        forEach(n -> {
          System.out.print("Number: ");
          System.out.println(n);
        }, numbers);

        Offset byTen = new Offset(10);
        Offset byFive = new Offset(5);

        forEach(byTen::printWithOffset, asList(1,2,3));
        System.out.println();
        forEach(byFive::printWithOffset, asList(1,2,3));
    }

    //from demo 4
    static <T> void forEach(Consumer<T> consumer, List<T> source){
        for (T item : source) {
            consumer.accept(item);
        }
    }

    public static class Offset {
        private int offset;

        public Offset(int offset){
            this.offset = offset;
        }

        public void printWithOffset(int number) {
            System.out.print(" " + (number + offset));
        }
    }

}
