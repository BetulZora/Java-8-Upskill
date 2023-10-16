package day4_streams1;

import java.util.Arrays;

public class TerminalOperations {
    public static void main(String[] args) {

        //TODO: import first few lines


        // Given a String, count the number of unique chars in the String
        String str = "aaaaaaabbbbbbcccccddddddeeeefffffaaaabbbbccddd";
        str.chars() // returns a stream
                .forEach(System.out::println);

        long distinctchars = str.chars()
                .distinct()
                .count();

        System.out.println("distinctchars = " + distinctchars);

        str.chars()
                .mapToObj(a->(char)a)
                .distinct()
                .forEach(System.out::println);


        System.out.println("=======================================");
        System.out.println("===========Different match operations");
        int[] nums = {4,5,15,20,19,7};

        System.out.println("\t\t\t All Match");
        boolean tmp = Arrays.stream(nums)
                // .allMatch( predicate)
                        .allMatch(p->p<30);
        System.out.println(tmp);

        System.out.println("\t\t\t Any Match");
        // are any divisible by 5?
        boolean isDivBy5 = Arrays.stream(nums)
                        .anyMatch(p-> p%5==0);
        System.out.println("isDivBy5 = " + isDivBy5);


        System.out.println("\t\t\t None Match");
        // Make sure none are div by 10
        boolean notBy10 = Arrays.stream(nums)
                        .noneMatch(p->p%10==0);
        System.out.println("notBy10 = " + notBy10);


        char[] mychars = new char[]{'a', 'b', 'c', 'd', 'e'};

        // Arrays.stream(mychars);

    }
}
