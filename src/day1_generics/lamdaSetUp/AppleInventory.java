package day1_generics.lamdaSetUp;

import java.util.ArrayList;
import java.util.List;

public class AppleInventory {

    static List<Apple> getInventory(){
        List<Apple> inventory = new ArrayList<>();
        inventory.add( new Apple("Green", 500));
        inventory.add( new Apple("Green", 400));
        inventory.add( new Apple("Green", 300));
        inventory.add( new Apple("Green", 200));
        inventory.add( new Apple("Green", 100));
        inventory.add( new Apple("Red", 500));
        inventory.add( new Apple("Red", 400));
        inventory.add( new Apple("Red", 300));
        inventory.add( new Apple("Red", 200));
        inventory.add( new Apple("Red", 100));
        inventory.add( new Apple("Yellow", 500));
        inventory.add( new Apple("Yellow", 400));
        inventory.add( new Apple("Yellow", 300));
        inventory.add( new Apple("Yellow", 200));
        inventory.add( new Apple("Yellow", 100));
        inventory.add( new Apple("Purple", 1000));

        return inventory;

    }
}
