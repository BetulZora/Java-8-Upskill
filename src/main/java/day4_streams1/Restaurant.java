package day4_streams1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Restaurant {
    public static void main(String[] args) {



        List<Entree> menu = new ArrayList<>(Arrays.asList(
           new Entree("Starter Salad", 300, true),
           new Entree("Fish And Chips", 700, false),
           new Entree("Cheese Pizza", 600, true),
           new Entree("Lentil Soup", 200, true),
           new Entree("Chicken Soup", 300, false)
        ));

        System.out.println("==================================\nVegetarian Options");
        long numOfVeg = menu.stream()
                .filter(Entree::isVegetarian)
                .count();
        System.out.println("Number of options: "+numOfVeg);
        menu.stream()
                .filter(Entree::isVegetarian)
                .forEach(System.out::println);
        boolean anyVegAtAll = menu.stream()
                .anyMatch(Entree::isVegetarian);

        System.out.println("anyVegAtAll = " + anyVegAtAll);


        System.out.println("======================================");
        System.out.println("================Sort entrees by cal high to low and remove biggest 2");
        menu.stream()
                .sorted(Comparator.comparing(Entree::getCalories).reversed())
                .skip(2)
                .map(Entree::getName)
                .forEach(System.out::println);


    }
}
