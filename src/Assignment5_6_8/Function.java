package Assignment5_6_8;
@FunctionalInterface
public interface Function<T , U , V> {
    public V apply (T t , U u);
}
