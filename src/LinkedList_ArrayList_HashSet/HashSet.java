package LinkedList_ArrayList_HashSet;

public class HashSet<E> {
    final static int defaultSize = 10 ;
    final Object[] data ;
    int size ;

    public HashSet(int arraySize) {
        this.data = new Object[arraySize];
    }
    public HashSet(){
        this(defaultSize);
    }
    public int getPosition(E element){
        if (element == null ) return 0 ;
        int hashCode = Math.abs(element.hashCode());
        int position = hashCode% data.length;
        return position;
    }
}
