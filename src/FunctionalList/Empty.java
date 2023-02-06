package FunctionalList;

import Assignment5_6_8.CBiFunction;

import java.util.function.Function;
import java.util.function.Predicate;

public class Empty <E> extends FList<E>{
    @Override
    public E head() {
        throw new IllegalStateException("No Head For Empty");
    }

    @Override
    public FList<E> tail() {
        throw new IllegalStateException("No Tail For Empty");
    }

    @Override
    public boolean isEmpty() {
        return true;
    }

    @Override
    public FList<E> set(E head) {
        throw new IllegalStateException("You Cannot Set Head For Empty");
    }

    @Override
    public FList<E> drop(int n) {
        return this;
    }

    @Override
    public FList<E> dropWhile(Predicate<E> condition) {
        return this;
    }

    @Override
    public FList<E> reverse() {
        return this;
    }

    @Override
    public FList<E> init() {
        return this;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public <U> U reduceL(U seed, CBiFunction<U, E, U> function) {
        return seed;
    }

    @Override
    public <U> U reduceR(U seed, CBiFunction<E, U, U> function) {
        return seed;
    }

    @Override
    public <U> FList<U> map(Function<E, U> function) {
        return FList.empty();
    }

    @Override
    public <U> FList<U> flatMap(Function<E, FList<U>> function) {
        return FList.empty();
    }

    @Override
    public FList<E> filter(Predicate<E> condition) {
        return this;
    }

    @Override
    public String toString() {
        return "[NIL]";
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Empty;
    }
}
