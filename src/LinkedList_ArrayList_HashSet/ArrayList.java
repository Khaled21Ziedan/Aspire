package LinkedList_ArrayList_HashSet;

import Function.CBiFunction;
import Function.Function;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Optional;
import java.util.function.Predicate;

public class ArrayList<T> {
    private Object[] data;
    private int size;
    public static final int defaultSize = 10;

    public ArrayList(Object[] data, int size) {
        this.data = data;
        this.size = size;
    }

    public Object[] getData() {
        return data;
    }

    public int getSize() {
        return data.length;
    }

    public ArrayList() {
        this(new Object[defaultSize], 0);
    }
    @SafeVarargs
    public static <T> ArrayList<T> of(T... data) {
        return new ArrayList<>(data, data.length);
    }

    public Optional<T> get(int index) {
        return index < 0 || index > size ? Optional.empty() : Optional.of((T) data[index]);
    }

    public <T> ArrayList<T> set(int index, T element) {
        expandIfNeeded(index);
        data[index] = element;
        size = size > index + 1 ? size : index + 1;
        return (ArrayList<T>) this;
    }

    public <T> ArrayList<T> addLast(T element) {
        set(size, element);
        return (ArrayList<T>) this;
    }

    public <T> ArrayList<T> addFirst(T element) {
        expandIfNeeded(size);
        System.arraycopy(data, 0, data, 1, size);
        data[0] = element;
        size++;
        return (ArrayList<T>) this;
    }

    public Optional<T> removeByIndex(int index) {
        T removedElement = (T) data[index];
        if (index < 0 || index >= size) return Optional.empty();
        System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[--size] = null;
        return Optional.of(removedElement);
    }

    public boolean contains(Object target) {
        Iterator<T> iterator = iterator();
        while (iterator.hasNext()) {
            Object element = iterator.next();
            if (element.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<T> filter(Predicate<? super T> filter) {
        return reduceL(new ArrayList<T>(), acc -> e -> filter.test(e) ? acc.addLast(e) : acc);
    }

    public ArrayList<T> addAll(ArrayList<? extends T> another) {
        Iterator<? extends T> iterator = another.iterator();
        while (iterator.hasNext()) {
            Object next = iterator.next();
            addLast(next);
        }
        return this;
    }
    public <U>ArrayList<U> map(Function<? super T,? extends U> mapFunction) {
        return reduceL(new ArrayList<>(), acc -> e -> acc.addLast(mapFunction.apply(e)));
    }
    public <U>ArrayList<U> flatMap(Function<? super T, ArrayList<? extends U>> function) {
        return reduceL(new ArrayList<>(), acc -> e -> acc.addAll(function.apply(e)));
    }

    public <U> U reduceL(U seed, CBiFunction<U, T, U> accFunction) {
        return reduceL(seed, 0, accFunction);
    }

    public <U> U reduceL(U acc, int currentIndex, CBiFunction<U, T, U> accFun) {
        return currentIndex >= size ? acc : reduceL(accFun.apply(acc).apply((T) data[currentIndex]), currentIndex + 1, accFun);
    }

    public <U> U reduceR(U seed, CBiFunction<T, U, U> accFun) {
        return reduceR(seed, size - 1, accFun);
    }

    public <U> U reduceR(U acc, int currentIndex, CBiFunction<T, U, U> accFun) {
        return currentIndex < 0 ? acc : reduceR(accFun.apply((T) data[currentIndex]).apply(acc), currentIndex - 1, accFun);
    }

    public Iterator<T> iterator() {
        return new ArrayListIterator(0);
    }

    private void expandIfNeeded(int index) {
        if (index < data.length) return;
        int newArraySize = data.length * 2;
        newArraySize = index > newArraySize ? index + 1 : newArraySize;
        data = Arrays.copyOf(data, newArraySize);
    }

    public class ArrayListIterator implements Iterator<T> {
        int index = 0;

        public ArrayListIterator(int index) {
            this.index = index;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            if (index < 0 || index >= size) {
                throw new IndexOutOfBoundsException();
            }
            return (T) data[index++];
        }
    }
}
