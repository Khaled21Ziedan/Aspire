package LinkedList_ArrayList_HashSet;

import Function.CBiFunction;

import java.util.function.BiFunction;

public class Util {
    public static <T,U,V> CBiFunction<T,U,V> carrying (BiFunction<T,U,V> function){
        return a->b->function.apply(a,b);
    }
}
