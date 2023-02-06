package FunctionalList;

import Assignment5_6_8.CBiFunction;
import TailCall.TailCall;

import java.util.function.Function;
import java.util.function.Predicate;

import static TailCall.TailCall.result;
import static TailCall.TailCall.suspend;

public class FListImpl<E> extends FList<E> {
    private final E head;
    private final FList<E> tail;
    private final int size;

    public FListImpl(E head, FList<E> tail) {
        this.head = head;
        this.tail = tail;
        this.size = tail.size() + 1;
    }

    @Override
    public E head() {
        return head;
    }

    @Override
    public FList<E> tail() {
        return tail;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public FList<E> set(E newHead) {
        return new FListImpl<E>(newHead, tail);
    }

    @Override
    public FList<E> drop(int n) {
        return n <= 0 ?
                this
                : drop(this, n).eval();
    }

    private TailCall<FList<E>> drop(FList<E> efList, int n) {
        return n <= 0 || efList.isEmpty()
                ? result(efList)
                : suspend(() -> drop(efList.tail(), n - 1));
    }

    @Override
    public FList<E> dropWhile(Predicate<E> condition) {
        return dropWhile(this,condition).eval();
    }
    public TailCall<FList<E>> dropWhile(FList<E> efList,Predicate<E> condition) {
        return efList.isEmpty() || !condition.test(efList.head())
                ? result(efList)
                : suspend(()->dropWhile(efList.tail(),condition));
    }
    @Override
    public FList<E> reverse() {
        return reverse(empty(),this).eval();
    }

    private <E> TailCall<FList<E>> reverse(FList<E> acc, FList<E> efList) {
        return isEmpty()
                ? result(acc)
                : suspend(()-> reverse(new FListImpl<>(efList.head(),acc),efList.tail()));
    }

    @Override
    public FList<E> init() {
        return reverse().tail().reverse();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public <U> U reduceL(U seed, CBiFunction<U, E, U> reduceFunction) {
        return reduceL(this,seed,reduceFunction).eval();
    }

    private <U> TailCall<U> reduceL(FList<E> efList, U acc, CBiFunction<U,E,U> reduceFunction) {
        return efList.isEmpty()
                ? result(acc)
                : suspend(()->reduceL(efList.tail(),reduceFunction.apply(acc).apply(efList.head()),reduceFunction));
    }

    @Override
    public <U> U reduceR(U seed, CBiFunction<E, U, U> reduceFunction) {
        return reverse().reduceL(seed,e->acc->reduceFunction.apply(acc).apply(e));
    }

    @Override
    public <U> FList<U> map(Function<E, U> mapFunction) {
        return reduceL(empty(),acc->e->new FListImpl<>(mapFunction.apply(e),acc));
    }

    @Override
    public <U> FList<U> flatMap(Function<E, FList<U>> flatMapFunction) {
        return reduceR(empty(),e->acc->concat(flatMapFunction.apply(e),acc));
    }

    @Override
    public FList<E> filter(Predicate<E> condition) {
        return reduceR(empty(),e->acc->condition.test(e)?addFirst(e):acc);
    }
}
