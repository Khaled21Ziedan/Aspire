package Function;
@FunctionalInterface
public interface Function<T , V> {
    public V apply (T t);
    default <W>Function<W,V> compose(Function<? super W, ? extends T> g ){
        return a -> apply(g.apply(a));
    }
    default <W>Function<T,W> andThen(Function<? super V , ? extends W> g){
        return a -> g.apply(apply(a));
    }
}
