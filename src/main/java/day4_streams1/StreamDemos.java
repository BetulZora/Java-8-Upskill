package day4_streams1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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









    }
}
