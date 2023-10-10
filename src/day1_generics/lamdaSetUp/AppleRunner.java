package day1_generics.lamdaSetUp;

import java.util.ArrayList;
import java.util.List;

public class AppleRunner {


    public static void main(String[] args) {

        List<Apple> inventory;



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
