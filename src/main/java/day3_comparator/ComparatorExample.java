package day3_comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ComparatorExample {
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(4, 2, 1, 6, 21, 5, 2, 10, 14));

        System.out.println("Original:");
        nums.forEach(System.out::println);
        System.out.println("\nSort In Ascending Order ++++++++++++++++++++++++++++++++");
        Collections.sort(nums);
        nums.forEach(System.out::println);
        System.out.println("\nSort In Descending Order ++++++++++++++++++++++++++++++++");
        Collections.sort(nums, (n1,n2)-> n1>n2 ? -1 : n1<n2 ? 1 : 0);
        nums.forEach(System.out::println);

        System.out.println("\nSort In Ascending Order With compareTo ++++++++++++++++++++++++++++++++");
        Collections.sort(nums, (n1, n2) -> n1.compareTo(n2));
        nums.forEach(System.out::println);




    }
}
