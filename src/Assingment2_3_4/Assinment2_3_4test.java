package Assingment2_3_4;

import Function.Function;

import java.util.Scanner;

public class Assinment2_3_4test {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Your Name ");
        String name = sc.next();

        Function<String,String> greeting = x -> "Hello "+name;
        System.out.println(greeting.apply(name));

        Function<String,String> cnv = x->x.toUpperCase();
        System.out.println(cnv.apply(name));

        Function<String,String> compose = cnv.compose(greeting);
        System.out.println(compose.apply(name));

    }
}
