public class RecursionTest {
    public static int add (int x , int y ){
        return y == 0 ? x : add(x+1,y-1);
    }
}
