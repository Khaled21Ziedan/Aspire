package LinkedList_ArrayList_HashSet;

import java.util.Iterator;
import java.util.Optional;
import java.util.function.BiFunction;

import Function.CBiFunction;

public class LinkedList<E> {
    private int size;
    private Node first;
    private Node last;

    public class Node {
        private Node previous;
        private Node next;
        private E data;

        public Node(Node previous, Node next, E data) {
            this.previous = previous;
            this.next = next;
            this.data = data;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    '}';
        }
    }

    public Optional<E> first() {
        return first == null ? Optional.empty() : Optional.of(first.data);
    }

    public Optional<E> last() {
        return last == null ? Optional.empty() : Optional.of(last.data);
    }

    public void push(E e) {
        addFirst(e);
    }

    public void addFirst(E e) {
        Node oldFirst = first;
        Node newFirst = new Node(null, oldFirst, e);
        first = newFirst;
        if (oldFirst == null) {
            last = newFirst;
        } else {
            oldFirst.previous = newFirst;
        }
    }

    public void addLast(E e) {
        Node oldLast = last;
        Node newLast = new Node(last, null, e);
        last = newLast;
        if (oldLast == null) {
            first = newLast;
        } else {
            oldLast.next = newLast;
        }
    }

    public LinkedList addAll(LinkedList<? extends E> another) {
        Iterator<? extends E> iterator = another.iterator();
        while (iterator.hasNext()) {
            push(iterator.next());
        }
        return this;
    }

    public <U> U reduceL(U seed, BiFunction<? super U, ? super E, ? extends U> acc) {
        return reduceL(seed, Util.carrying(acc));
    }

    public <U> U reduceL(U seed, CBiFunction<? super U, ? super E, ? extends U> acc) {
        U result = seed;
        Iterator<? extends E> iterator = new MyLinkedListIterator(this.first);
        while (iterator.hasNext()) {
            E next = iterator.next();
            result = acc.apply(result).apply(next);
        }
        return result;
    }

    public Iterator<E> iterator() {
        return new MyLinkedListIterator(first);
    }

    public class MyLinkedListIterator implements Iterator<E> {
        private Node currentNode;
        private Node lastAccessNode;

        public MyLinkedListIterator(Node first) {
            this.currentNode = first;
        }

        @Override
        public boolean hasNext() {
            return currentNode != null;
        }

        @Override
        public E next() {
            lastAccessNode = currentNode;
            currentNode = currentNode.next;
            return lastAccessNode.data;
        }
    }
}
