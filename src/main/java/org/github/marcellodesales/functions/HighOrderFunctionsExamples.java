package org.github.marcellodesales.functions;

import static java.util.Arrays.asList;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.github.marcellodesales.Jedi;

/**
 * Demonstration instance method references to an arbitrary object.
 *
 * @author Edwin Dalorzo
 */
public class HighOrderFunctionsExamples {

    public static void main(String[] args) {
        List<String> digits = asList("1","2","3","4","5");
        List<Object> myDoubles = map(Double::new, digits);
        List<Jedi> jedi = asList(new Jedi("Obi-wan", 80), new Jedi("Anakin", 25), new Jedi("Yoda", 500));
        List<String> names = map(Jedi::getName, jedi);
    }

    //from demo 2
    static <T,R> List<R> map(Function<T,R> function, List<T> source) {
        List<R> destiny = new ArrayList<>();
        for (T item : source) {
            R value = function.apply(item);
            destiny.add(value);
        }
        return destiny;
    }


}
