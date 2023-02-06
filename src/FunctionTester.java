import java.util.function.Function;
public class FunctionTester {
    public static void main(String[] args) {
        Function<Integer, Integer> multiply = t -> t *3;
        Function<Integer, Integer> add = t -> t  + 3;
        Function<Integer, Integer> FirstMultiplyThenAdd = multiply.compose(add);
        Function<Integer, Integer> FirstAddThenMultiply = multiply.andThen(add);

    }
}