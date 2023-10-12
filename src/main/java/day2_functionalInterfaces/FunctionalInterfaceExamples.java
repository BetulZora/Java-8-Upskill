package day2_functionalInterfaces;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FunctionalInterfaceExamples {
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(5,6,7,8,9,2,33,4,55,67,8,97,87,66,44,11));

        System.out.println("---------Predicate-----------------");

        // n is assumed type integer
        Predicate<Integer>lessThan10 = n -> n<10;
        System.out.println(lessThan10.test(5));
        // nums.removeIf(n -> n <10 ); // remove if usage
        nums.removeIf(lessThan10);
        System.out.println(nums);






    }
}
