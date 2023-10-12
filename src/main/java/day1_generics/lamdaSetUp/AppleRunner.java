package day1_generics.lamdaSetUp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AppleRunner {


    public static void main(String[] args) {

        List<Apple> inventory = AppleInventory.getInventory();

        System.out.println("GREEN APPLES:");
        System.out.println(filterApples(inventory, new AppleGreenColorPredicate()).toString());
        System.out.println("HEAVY APPLES");
        System.out.println(filterApples(inventory, new AppleHeavyPredicate()).toString());
        System.out.println("Find the purple Apples");
        System.out.println(filterApples(inventory, apple -> apple.getColor().toLowerCase().equals("purple")));


    }



    static List<Apple> filterApples(List<Apple> apples, ApplePredicate predicate){

        List<Apple> mylist = new ArrayList<>();
        for(Apple each : apples){
            if(predicate.test(each)){
                mylist.add(each);
            }
        }

        return mylist;


    }



}
