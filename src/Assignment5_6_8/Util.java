package Assignment5_6_8;

import Function.CBiFunction;

import java.util.function.BiFunction;

public class Util {
    public static <T,U,V> CBiFunction<T,U,V> carrying (BiFunction<T,U,V> function){
        return a->b->function.apply(a,b);
    }
    public static <T,U,V> Function<T,U,V> uncarrying (Function<T,U,V> function) { return (a,b) -> function.apply(a,b);  }
    public static <T,U,V> BiFunction<U,T,V> flipFunction(BiFunction<T,U,V> function){return (a,b)-> function.apply(b,a);}
}
