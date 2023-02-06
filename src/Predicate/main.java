package Predicate;
public class main {
    public static void main(String[] args) {

    IntPredicate isOdd = x-> x%2 != 0 ;
    System.out.println(isOdd.apply(15));
    IntPredicate greaterThan10 = x -> x > 10;
    System.out.println(greaterThan10.apply(9));

    StrPredicate startsWithA = x -> x.startsWith("A");
    System.out.println(startsWithA.apply("Ah"));
    System.out.println(startsWithA.apply("Mo"));
    }
}