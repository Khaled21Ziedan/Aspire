package Assignment5_6_8;

import java.util.function.BiFunction;

public class FunctionsTest {
    public static void main(String[] args) {
        Function<Integer,Integer,Integer> add = (a,b) -> a + b ;
        System.out.println("add.apply(3,5) = " + add.apply(3, 5));

        CBiFunction<Integer,Integer,Integer> add1 = a -> b -> a+b;
        System.out.println("add1.apply(6).apply(8) = " + add1.apply(6).apply(8));

        BiFunction<Integer,Integer,Integer> subtract = (a, b) -> a-b;
        System.out.println("subtract.apply(5,6) = " + subtract.apply(10, 33));

        BiFunction<Integer, Integer, Integer> flippedFunction = Util.flipFunction(subtract);
        System.out.println("integerIntegerIntegerBiFunction.apply(5,6) = " + flippedFunction.apply(10, 33));


    }
}
