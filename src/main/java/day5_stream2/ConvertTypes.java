package day5_stream2;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ConvertTypes {
    public static void main(String[] args) {

        // convert from int[] to List<Integer>

        int[] nums = {2,3,4,5,6,7,8,1,2,3,4,5,6,7,8};
        List<Integer> numsList = Arrays.stream(nums)
                .boxed()// this boxes ints to wrapper. Converts IntStream to Stream<Integer>
                .collect(Collectors.toList());

        // convert List<Integer> to int[]
        List<Integer> listNums = List.of(3,4,32,5,1);
        //List.of creates immutable unmodifiable list.

        int[] arr2 = listNums.stream()
                .mapToInt(n -> n) // converts Stream<Integer> to IntStream
                .toArray(); // this creats a problem because toArray returns an Object Array
        System.out.println("Arrays.toString(arr2) = " + Arrays.toString(arr2));


        // this creates a stream of numbers 1 to 30-1.
        IntStream.range(1,30).forEach(System.out::println);


    }
}
