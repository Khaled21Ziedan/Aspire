package Streams;

import Assignment5_6_8.CBiFunction;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ReducerApplication {
    @SafeVarargs
    public static  <E,A> A reduceL(CBiFunction<A, E, A> accumulator, A initial, E... array){
        A result = initial;
        if (array == null ){
            return result;
        }
        for (E element : array) {
            result = accumulator.apply(result).apply(element);
        }
        return result;
    }
    @SafeVarargs
    public static  <E,A> A reduceR(CBiFunction<E, A, A> accumulator, A initial, E... array){
        A result = initial;
        if (array == null ){
            return result;
        }
        for (E element : array) {
            result = accumulator.apply(element).apply(result);
        }
        return result;
    }

    public static void main(String[] args) {
        Integer sum = reduceL(acc -> e -> acc + e, 0, 1, 2, 3);
        System.out.println("sum = " + sum);
        Integer subtract = reduceR(e -> acc -> acc - e, 0, 1, 2, 3);
        System.out.println("subtract = " + subtract);

    }
}
