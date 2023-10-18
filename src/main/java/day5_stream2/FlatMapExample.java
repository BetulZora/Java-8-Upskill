package day5_stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FlatMapExample {
    public static void main(String[] args) {
        int[][] nums = {
                {1,2,3},
                {4,5,6},
                {7,8,9,0}
        };

        int[] combined = Arrays.stream(nums)
                .flatMapToInt(Arrays::stream)
                .toArray();

        System.out.println("Arrays.toString(combined) = " + Arrays.toString(combined));


        List<List<String>> namesList = Arrays.asList(
                Arrays.asList("James", "Tim", "Bob"),
                Arrays.asList("Alana", "Daine", "Keladry"),
                Arrays.asList("Harry", "Ron", "Fred"),
                Arrays.asList("Richard", "Kahlan", "Cara")
        );

        List<String> allNames = namesList.stream() // a Stream<List<String>>
                .flatMap(List::stream) // a Stream<String>
                .map(str -> str + " " + str.length())
                .collect(Collectors.toList());

        System.out.println("allNames = " + allNames);


    }
}
