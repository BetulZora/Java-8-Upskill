package day4_streams1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamDemos {

    public static void main(String[] args) {

        System.out.println("------------------------------Stream from an Array");
        int[] arr = {3,4,5,6,7,3,3,3,3,3,3,3,3,8,8,9,3,55};
        Arrays.stream(arr).
        forEach(System.out::print);



        System.out.println("\n------------------------------Stream from an Array");
        List<Integer> list = new ArrayList<>(Arrays.asList(3,4,5,6,7,8,9,3,3,3,1,1,2,2,55));
        list.stream().forEach(System.out::println);

        System.out.println("\n------------------------------Distinct Keyword");
        list.stream().distinct().forEach(c -> System.out.println(c)); // forEach uses a consumer


        System.out.println("\n------------------------------Filter with Predicate");
        list.stream().filter(p->p%2==1)
                .forEach(System.out::println);

        System.out.println("\n------------------------------Filter with Predicate and get Distinct");
        list.stream().filter(p->p%2==1)
                .distinct()
                .forEach(System.out::println);

        System.out.println("\n------------------------------limit with an integer");
        list.stream().filter(p->p%2==0)
                .distinct()
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n------------------------------First 6 nums less than 4");
        list.stream()
                .filter(p -> p<4)
                .limit(6)
                .forEach(System.out::println);

        System.out.println("\n------------------------------skip with an integer" +
                "\nSkip some amount of elements");
        list.stream()
                .filter(p -> p%2 == 0)
                .distinct()
                .skip(2)
                .forEach(System.out::println);

        System.out.println("\n------------------------------can use skip and limit together");
        list.stream()
                .skip(4)
                .limit(3)
                .forEach(System.out::println);

        System.out.println("\n------------------------------map with a Function");
        list.stream()
                .map(m -> m*2)
                .forEach(System.out::println);

        System.out.println("\n------------------------------take first 6 and square values");
        list.stream()
                .limit(6)
                .map(m -> m*m)
                .forEach(System.out::println);

        System.out.println("\n------------------------------sorted ascending by default");
        list.stream()
                .sorted()
                .forEach(System.out::println);

        System.out.println("\n------------------------------sorted with Comparator");
        list.stream()
                .sorted(Comparator.reverseOrder())
                .forEach(System.out::println);







    }
}
