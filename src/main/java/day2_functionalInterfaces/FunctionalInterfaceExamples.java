package day2_functionalInterfaces;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.function.*;

public class FunctionalInterfaceExamples {
    public static void main(String[] args) {

        List<Integer> nums = new ArrayList<>(Arrays.asList(5,6,7,8,9,2,33,4,55,67,8,97,87,66,44,11));

        List<String> names = new ArrayList<>(Arrays.asList("Kelly", "James", "Eren", "Huong", "Oleg", "Salma"));

        System.out.println("---------Predicate-----------------");

        // n is assumed type integer
        Predicate<Integer>lessThan10 = n -> n<10;
        System.out.println(lessThan10.test(5));
        // nums.removeIf(n -> n <10 ); // remove if usage
        nums.removeIf(lessThan10);
        System.out.println(nums);

        // palindrome
        Predicate<String> isPalindrome = s -> new StringBuilder(s).reverse().toString().equals(s);
        System.out.println("Palindrome");
        System.out.println(isPalindrome.test("racecar"));
        System.out.println(isPalindrome.test("hello"));


        System.out.println("---------Consumer-----------------");
        // accept method
        // Print the first char of a String
        Consumer<String> firstChar = word -> System.out.println(word.charAt(0));
        firstChar.accept("Consumer");
        // it is void return

        // Recall the forEach() method. This is not the for each loop
        // forEach() can be used in any child of Iterable
        names.forEach(firstChar);
        names.forEach(s -> System.out.print(s + " "));
        System.out.println();
        names.forEach(s-> System.out.println(s.charAt(0) + " " + s));

        System.out.println("---------BiConsumer-----------------");
        // accept method

        BiConsumer<Integer, Integer> sum = (x,y) -> System.out.println(x+y);
        sum.accept(4,5);

        BiConsumer<List<String>, Integer> subNames = (listOfNames, end) -> {
            for (String each: listOfNames) {
                System.out.println(each.substring(0,end));

            }
        };

        subNames.accept(names, 3);

        System.out.println(" Using HashMaps/BiConsumer ====================================");
        System.out.println(" the forEach() method is in Iterable but Maps has a similar method\nWith the same name");
        Map<String, String> holidays = new HashMap<>();
        holidays.put("July", "Independence Day");
        holidays.put("September", "Labor Day");
        holidays.put("May", "Memorial Day");

        holidays.forEach((k,v) -> System.out.println(k + " " + v));


        System.out.println("---------Function-----------------");
        // two generics, first, accepting type, second return type
        // apply

        Function<String, Integer> countVowels = word -> {
            String vowels = "aeiou";
          int count = 0;
          for(char each :word.toCharArray()){
              if(vowels.contains(each+"")){
                  count++;
              }
          }
          return count; // need return statement if more than one line
        };

        System.out.println(countVowels.apply("Wooden Spoon"));

        System.out.println("Perform a Conversion with Function");
        // invert int[] to a List
        Function<int[], List<Integer>> toList = arr -> {
          List<Integer> list = new ArrayList<>();
          for(int each: arr){
              list.add(each);
          }
          return list;
        };

        int[] a = {6,5,3,2,1};

        List<Integer> aList = toList.apply(a);
        System.out.println(aList);

        System.out.println("---------Supplier-----------------");
        // One generic, no parameter, have a return type
        // Example, get the day of the week
        Supplier<String> getDay = () -> LocalDate.now().getDayOfWeek().name();
        System.out.println("getDay.get() = " + getDay.get());

        Supplier<String> getDateTime = () -> LocalDateTime.now().format(DateTimeFormatter.ofPattern("M/d/y h:m a"));
        System.out.println(getDateTime.get());


        // Get Random Number
        Supplier<Integer> getRandomNumber = () -> new Random().nextInt(1001);
        System.out.println("getRandomNumber.get() = " + getRandomNumber.get());


    }
}
