package day3_colonOperator;

import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceExamples {

    public static void main(String[] args) {

        System.out.println("======================================================");

        Consumer<Integer> printMe = n -> System.out.println(n);
        printMe.accept(10);

        // Here how to write it with method reference using Double Colon
        // Use method reference when the lamda is calling an action in the param in the lamda
        Consumer<Integer> printAgain = System.out::println;
        printAgain.accept(10000);

        System.out.println("======================================================");
        // write a reference to take a string and put it in lower case
        Function<String, String> toLower = s -> s.toLowerCase();
        Function<String, String> toLower2 = String::toLowerCase;
        System.out.println(toLower.apply("JAVA"));
        System.out.println(toLower2.apply("JAVA"));

        System.out.println("======================================================\nSupplier");
        Supplier<Double> randomNumLambda = () -> Math.random();
        System.out.println(randomNumLambda.get());

        Supplier<Double> randomNumColon = Math::random;
        System.out.println(randomNumColon.get());

        System.out.println("======================================================\nBiFunction");
        // take  a string and an index value, return upto that index
        BiFunction<String, Integer, String> subL = (str,i) -> str.substring(i);
        BiFunction<String, Integer, String> subC = String::substring;
        System.out.println("subL.apply(\"Friday\",3) = " + subL.apply("Friday", 3));
        System.out.println("subC.apply(\"Saturday\",3) = " + subC.apply("Saturday", 3));


    }
}
