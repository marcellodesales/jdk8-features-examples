package org.github.marcellodesales.streams;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * The Stream implementation demo.
 *
 * @author Edwin Dalorzo
 */
public class StreamImplementation {

    public static void main(String[] args) {
        List<Integer> smallerThan = new ArrayList<>();

        sieve(from(2)).takeWhile(n -> n < 100)
                .forEach(System.out::println);

        from(0).takeWhile(n -> n < 10)
                .filter(n -> n % 2!= 0)
                .forEach(System.out::println);

        fibonacci().takeWhile( n -> n <= 150)
                .forEach( n -> { smallerThan.add(n); } );

        System.out.println(smallerThan);

        List<Integer> primes = new ArrayList<>();

        sieve(from(2)).takeWhile( n -> n <= 1000)
                .forEach( n -> { primes.add(n); });

        System.out.println(primes);

        //since streams are also Iterable
        for(Integer prime : sieve(from(2)).takeWhile( n -> n <= 30)){
            System.out.print(prime + " ");
        }
        System.out.println("");


    }

    //creates infinite stream of numbers starting from n
    public static Stream<Integer> from(int n) {
        return new Cons<>(n, () -> from(n+1));
    }

    //sieve of eratosthenes: infinite sequence of prime numbers.
    public static Stream<Integer> sieve(Stream<Integer> s) {
        return new Cons<>(s.head(), ()-> sieve(s.tail().filter(n -> n % s.head() != 0)));
    }

    //infinite sequence of fibonacci numbers
    public static Stream<Integer> fibonacci() {
        //first two fibonacci and a thunk to get the rest.
        return new Cons<>(0,() -> new Cons<>(1, () -> nextFibPair(0,1)));
    }

    private static Stream<Integer> nextFibPair(int a, int b) {
        int fib = a + b, prev = b;
        //creates new cons cell and thunks the rest.
        return new Cons<>(fib, () -> nextFibPair(prev, fib));
    }


    public interface Stream<T> extends Iterable<T> {

        public T head();
        public Stream<T> tail();
        public boolean isEmpty();



        public default Stream<T> takeWhile(Predicate<? super T> predicate) {
            return takeWhile(this, predicate);
        }

        public static <T> Stream<T> takeWhile(Stream<? extends T> source, Predicate<? super T> predicate) {
            if(source.isEmpty() || !predicate.test(source.head())) {
                return new Empty<>();
            }
            //creates new cons cell and thunks the rest
            return new Cons<>(source.head(), () -> takeWhile(source.tail(), predicate));
        }


        public default void forEach(Consumer<? super T> consumer) {
            forEach(this, consumer);
        }

        public static <T> void forEach(Stream<T> source, Consumer<? super T> consumer) {
            while(!source.isEmpty()) {
                consumer.accept(source.head());
                //triggers thunk evaluation
                source = source.tail();
            }
        }


        public default Stream<T> filter(Predicate<? super T> predicate) {
            return filter(this, predicate);
        }

        public static <T> Stream<T> filter(Stream<? extends T> source, Predicate<? super T> predicate) {
            if(source.isEmpty()) {
                return new Empty<>();
            }
            if(predicate.test(source.head())) {
                return new Cons<>(source.head(), () -> filter(source.tail(), predicate));
            }
            return filter(source.tail(), predicate);
        }

        @Override
        public default Iterator<T> iterator() {
            return iterator(this);
        }

        public static <T> Iterator<T> iterator(Stream<? extends T> source) {
            return new Iterator<T>() {

                private Stream<? extends T> current;

                public boolean hasNext() {
                    if(current == null) {
                        current = source;
                    } else {
                        current = current.tail();
                    }
                    return !current.isEmpty();
                }

                public T next() {
                    if(current != null || hasNext()){
                        if(!current.isEmpty()) {
                            T result = current.head();
                            return result;
                        }
                    }
                    throw new NoSuchElementException("Empty list");
                }
            };
        }
    }

    public static class Empty<T> implements Stream<T> {
        @Override public T head() { throw new UnsupportedOperationException("Empty stream"); }
        @Override public Stream<T> tail() { throw new UnsupportedOperationException("Empty stream"); }
        @Override public boolean isEmpty() { return true; }
        @Override public String toString() { return "[]"; }
    }

    public static class Cons<T> implements Stream<T>{

        private final T head;
        //stream thunk
        private final Supplier<Stream<T>> tail;

        public Cons(T head, Supplier<Stream<T>> tail) {
            this.head = head;
            this.tail = tail;
        }

        @Override
        public T head() {
            return this.head;
        }

        @Override
        public Stream<T> tail() {
            //triggers thunk evaluation
            return this.tail.get();
        }

        @Override
        public boolean isEmpty() {
            return false;
        }

        @Override
        public String toString() {
            return String.format("%s::???", this.head);
        }
    }

}
