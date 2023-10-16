package day4_streams1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class HR {
    public static void main(String[] args) {
        List<Application> applications = new ArrayList<>(Arrays.asList(
                new Application("Molly", 100_000, true),
                new Application("James", 110_000, false),
                new Application("Emre", 125_000, true),
                new Application("Oleg", 120_000, false),
                new Application("Ella", 95_000, true),
                new Application("Poppy", 135_000, false),
                new Application("Steve", 250_000, false)
        ));

        System.out.println("-----\nTASK: applicants willing to relocate");
        applications.stream()
                .filter(Application::isWillingToRelocate)
                .forEach(System.out::println);

        System.out.println("-----\nTASK: get names of people willing to relocate");
        applications.stream()
                .filter(Application::isWillingToRelocate)
                .map(Application::getName)
                .forEach(System.out::println);

        System.out.println("-----\nTASK: get people expecting less than 125000");
        applications.stream()
                .filter(p -> p.getExpectedSalary() < 125_000)
                .forEach(System.out::println);


        System.out.println("-----\nTASK: get people expecting less than 125000 and willing to relocate");
        applications.stream()
                .filter(p -> p.getExpectedSalary() < 125_000)
                .filter(Application::isWillingToRelocate)
                .forEach(System.out::println);

        System.out.println("-----\nTASK: get applications sorted by salaries sorted lowest to highest");
        applications.stream()
                .sorted(Comparator.comparing(Application::getExpectedSalary))
                .forEach(System.out::println);

        System.out.println("-----\nTASK: get applications sorted by salaries sorted highest to lowest");
        applications.stream()
                .sorted(Comparator.comparing(Application::getExpectedSalary).reversed())
                .forEach(System.out::println);

        System.out.println("-----\nTASK: get applications lowest 3 expected salary");
        applications.stream()
                .sorted(Comparator.comparing(Application::getExpectedSalary))
                .limit(3)
                .forEach(System.out::println);


    }
}
