package Function;

public class FunctionTest {
    public static void main(String[] args) {
        IntFunction add = x->x+10;
        IntFunction multiply = x->x*2;
        IntFunction multiplyThenAdd = add.compose(multiply);
        IntFunction addThenMultiply = add.andThen(multiply);
        System.out.println(addThenMultiply.apply(6));
        System.out.println(multiplyThenAdd.apply(2));
    }
}
