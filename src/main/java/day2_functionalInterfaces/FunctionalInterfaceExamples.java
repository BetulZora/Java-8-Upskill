package day2_functionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Predicate;

public class FunctionalInterfaceExamples {
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(5,6,7,8,9,2,33,4,55,67,8,97,87,66,44,11));

        List<String> names = new ArrayList<>(Arrays.asList("Kelly", "James", "Eren", "Huong", "Oleg", "Salma"));

        System.out.println("---------Predicate-----------------");

        // n is assumed type integer
        Predicate<Integer>lessThan10 = n -> n<10;
        System.out.println(lessThan10.test(5));
        // nums.removeIf(n -> n <10 ); // remove if usage
        nums.removeIf(lessThan10);
        System.out.println(nums);

        // palindrome
        Predicate<String> isPalindrome = s -> new StringBuilder(s).reverse().toString().equals(s);
        System.out.println("Palindrome");
        System.out.println(isPalindrome.test("racecar"));
        System.out.println(isPalindrome.test("hello"));


        System.out.println("---------Consumer-----------------");
        // accept method
        // Print the first char of a String
        Consumer<String> firstChar = word -> System.out.println(word.charAt(0));
        firstChar.accept("Consumer");
        // it is void return

        // Recall the forEach() method. This is not the for each loop
        // forEach() can be used in any child of Iterable
        names.forEach(firstChar);
        names.forEach(s -> System.out.print(s + " "));
        System.out.println();
        names.forEach(s-> System.out.println(s.charAt(0) + " " + s));

        System.out.println("---------BiConsumer-----------------");
        // accept method

        BiConsumer<Integer, Integer> sum = (x,y) -> System.out.println(x+y);
        sum.accept(4,5);

        BiConsumer<List<String>, Integer> subNames = (listOfNames, end) -> {
            for (String each: listOfNames) {
                System.out.println(each.substring(0,end));

            }
        };

        subNames.accept(names, 3);

        System.out.println(" Using HashMaps/BiConsumer ====================================");









    }
}
