package day3_colonOperator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;

public class UserRunner {
    public static void main(String[] args) {
        List<User> users = new ArrayList<>(Arrays.asList(
                new User("jbond7", "007"),
                new User("javaLover", "java"),
                new User("sdetFan", "testing"),
                new User("programmingIsFun", "java"),
                new User("codeFreak", "coder")
        ));

        users.forEach(user -> System.out.println(user)); // this is the lambda
        users.forEach(System.out::println); // as a method reference


        users.removeIf(p -> p.getPassword().equals("java"));
        System.out.println("REMOVED -----------------------------------");
        users.forEach(System.out::println);

        System.out.println("Constructor Lambda -------------------------------");
        BiFunction<String, String, User> createUserL = (user, pass) -> new User(user,pass);
        BiFunction<String, String, User> createUserC = User::new;

        User newUser = createUserL.apply("catsAreTheBest", "noDogs");
        User anUser = createUserC.apply("CatLady","Boss");
        System.out.println(newUser);
        System.out.println(anUser);
    }


}
