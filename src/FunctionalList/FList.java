package FunctionalList;

import Assignment5_6_8.CBiFunction;

import java.util.function.Function;
import java.util.function.Predicate;

public abstract class FList <E>{
    public abstract E head();
    public abstract FList<E> tail();
    public abstract boolean isEmpty();
    public abstract FList<E> set(E head);
    public abstract FList<E> drop(int n);
    public abstract FList<E> dropWhile(Predicate<E> condition);
    public abstract FList<E> reverse();
    public abstract FList<E> init();
    public abstract int size();
    public abstract <U> U reduceL(U seed , CBiFunction<U,E,U> function );
    public abstract <U> U reduceR(U seed , CBiFunction<E,U,U> function );
    public abstract <U> FList<U> map(Function<E,U> function);
    public abstract <U> FList<U> flatMap(Function<E,FList<U>> function);
    public abstract FList<E> filter(Predicate<E> condition);
    private static final Empty EMPTY = new Empty();
    protected static <U> FList<U> empty() {
        return EMPTY;
    }
    public static <U,E> U reduceL(U seed , CBiFunction<U,E,U> reduceFunction,FList<E> list){
        return list.reduceL(seed,reduceFunction);
    }
    public FList<E> addFirst(E head){
        return new FListImpl<E>(head,this);
    }
    public static <E> FList<E> concat(FList<E> first,FList<E> second){
        return first.reduceR(second,e->acc-> acc.addFirst(e));
    }
}
