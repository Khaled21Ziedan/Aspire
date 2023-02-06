package LinkedList_ArrayList_HashSet;

import java.util.Iterator;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList1st = new LinkedList<>();
        linkedList1st.push(30);
        linkedList1st.push(40);
        linkedList1st.push(60);

        System.out.println("linkedList1st.first() = " + linkedList1st.first());

        linkedList1st.addFirst(11);
        linkedList1st.addLast(77);

        Iterator<Integer> iterator = linkedList1st.iterator();
        System.out.println("First LinkedList");
        while (iterator.hasNext()) {
            Integer next = iterator.next();
            System.out.println(next);
        }

        LinkedList<Integer> linkedList2nd = new LinkedList<>();
        linkedList2nd.push(70);
        linkedList2nd.push(80);

        LinkedList<Integer> linkedList = linkedList1st.addAll(linkedList2nd);

        Iterator<Integer> linkedListIterator = linkedList1st.iterator();
        System.out.println("First LinkedList Added To The Second");
        while (linkedListIterator.hasNext()) {
            System.out.println("LinkedListIterator.next() = " + linkedListIterator.next());
        }
        Integer sum = linkedList.reduceL(0, acc -> e -> acc + e);
        System.out.println("sum = " + sum);

        ArrayList<Integer> myArrayList = ArrayList.of(1, 2, 3);

        System.out.println("myArrayList.get(1) = " + myArrayList.get(1));

        Optional<Integer> removedElement = myArrayList.removeByIndex(1);
        System.out.println("removedElement = " + removedElement);

        System.out.println("myArrayList.get(1) = " + myArrayList.get(1));
        System.out.println("myArrayList.get(5) = " + myArrayList.get(5));
        System.out.println("myArrayList.get(-2) = " + myArrayList.get(-2));

        myArrayList.set(2, 7);
        System.out.println("myArrayList.get(2) = " + myArrayList.get(2));

        myArrayList.set(11, 99);
        System.out.println("myArrayList.getSize() = " + myArrayList.getSize());

        myArrayList.addFirst(99);
        myArrayList.addLast(100);

        Iterator<Integer> arrayListIterator = myArrayList.iterator();
        while (arrayListIterator.hasNext()) {
            Integer next = arrayListIterator.next();
            System.out.println("ArrayListIterator = " + next);
        }
    }
}
