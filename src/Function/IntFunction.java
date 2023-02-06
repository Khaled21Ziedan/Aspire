package Function;

public interface IntFunction {
    public int apply(int other);

    default IntFunction compose(IntFunction other) {
        return a-> apply(other.apply(a));
    }

    default IntFunction andThen(IntFunction ohter) {
        return a-> ohter.apply(apply(a));
    }
}
