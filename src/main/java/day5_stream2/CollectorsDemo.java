package day5_stream2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsDemo {
    public static void main(String[] args) {

        Integer[] arr = {12, 3, 4, 5, 6, 2,3, 44, 55, 22, 80};
        arr = Arrays.stream(arr)
                .filter(p->p%5==0)
                .toArray(Integer[]::new);


        // toCollection
        List<Integer> list = Arrays.stream(arr)
                .collect(Collectors.toCollection(ArrayList::new));

        // toList
        List<Integer> byTen = list.stream().map(m-> m*2).sorted().collect(Collectors.toList());

        byTen.addAll(Arrays.asList(1,2,3,4,5,6,7,8,9,99));

        List<Integer> list2 = byTen;

        //toSet
        Set<Integer> set = list2.stream()
                .map(n->n*4)
                .collect(Collectors.toSet());
        System.out.println("set = " + set);


    }
}
