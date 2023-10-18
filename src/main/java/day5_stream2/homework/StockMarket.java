package day5_stream2.homework;


import java.util.*;
import java.util.stream.Collectors;


public class StockMarket {
    public static void main(String[] args) {

        Trader[] traders = {
                new Trader("David", "Virginia"),
                new Trader("Jika", "Chicago"),
                new Trader("Mark", "New York"),
                new Trader("Maria", "New York"),
                new Trader("Emre", "Chicago"),
                new Trader("Olesea", "New York"),
                new Trader("Alma", "Virginia"),
        };

        List<Transaction> transactions = new ArrayList<>(Arrays.asList(
                new Transaction(traders[0], "Apple", 2019, 1000),
                new Transaction(traders[3], "Tesla", 2020, 2500),
                new Transaction(traders[2], "Meta", 2022, 1200),
                new Transaction(traders[1], "Uber", 2018, 400),
                new Transaction(traders[4], "Ford", 2019, 1400),
                new Transaction(traders[2], "Amazon", 2023, 3400),
                new Transaction(traders[6], "Apple", 2020, 1300),
                new Transaction(traders[5], "Meta", 2018, 700),
                new Transaction(traders[4], "Meta", 2019, 600),
                new Transaction(traders[6], "Ford", 2019, 340),
                new Transaction(traders[2], "Uber", 2020, 890),
                new Transaction(traders[3], "Apple", 2020, 1290),
                new Transaction(traders[1], "Uber", 2023, 820),
                new Transaction(traders[0], "Amazon", 2017, 1230),
                new Transaction(traders[5], "Uber", 2016, 980),
                new Transaction(traders[3], "Ford", 2018, 650),
                new Transaction(traders[6], "Meta", 2023, 1320),
                new Transaction(traders[0], "Tesla", 2023, 2300)
        ));


        //            1) all transactions in 2020 and sort by highest value
        System.out.println("\nTASK: all transactions in 2020 and sort by highest value");
        transactions.stream()
                .filter(p->p.getYear()==2020)
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .forEach(System.out::println);

        //            2) Find the 3 biggest transactions
        System.out.println("\nTASK: Find the 3 biggest transactions");
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue).reversed())
                .limit(3)
                .forEach(System.out::println);

        //            3) Find the company's name with the smallest 2 transactions
        System.out.println("\nTASK: Find the company's name with the smallest 2 transactions");
        transactions.stream()
                .sorted(Comparator.comparing(Transaction::getValue))
                .limit(2)
                .map(Transaction::getCompany)
                .forEach(System.out::println);

        //            4) find all the cities trades were made in
        System.out.println("\nTASK: Find all the cities trades were made in");
        transactions.stream()
                .map(Transaction::getTrader)
                .map(Trader::getCity)
                .distinct()
                .forEach(System.out::println);

        //            5) find all the transactions of Meta
        System.out.println("\nTASK: Find all the transactions of Meta");
        transactions.stream()
                .filter(p->p.getCompany().equals("Meta"))
                .forEach(System.out::println);

        //            6) find all the traders that are from New York
        System.out.println("\nTASK: Find all the traders that are from New York");
        Arrays.stream(traders)
                .filter(p-> p.getCity().equals("New York"))
                .forEach(System.out::println);

        //            7) find all the trader's names that are from Chicago
        System.out.println("\nTASK: Find all the trader's names that are from Chicago");
        Arrays.stream(traders)
                .filter(p-> p.getCity().equals("Chicago"))
                .map(Trader::getName)
                .forEach(System.out::println);

        //            8) find all the trader's names and sort them alphabetically
        System.out.println("\nTASK: Find all the trader's names and sort them alphabetically");
        Arrays.stream(traders)
                .map(Trader::getName)
                .sorted()
                .forEach(System.out::println);

        //            9) find if there is any Traders from Los Angeles
        System.out.println("\nTASK: Find if there is any Traders from Los Angeles");
        boolean ifFromLosAngeles = Arrays.stream(traders)
                .anyMatch(p->p.getCity().equals("Los Angeles"));
        System.out.println("ifFromLosAngeles = " + ifFromLosAngeles);

        //            10) find the values of the transactions Mark was involved in
        System.out.println("\nTASK: Find the values of the transactions Mark was involved in");
        transactions.stream()
                .filter(p->p.getTrader().getName().equals("Mark"))
                .map(Transaction::getValue)
                .forEach(System.out::println);

        System.out.println("\nTASK: use the toMap() Method of Collectors");
        Map<String, String> traderMap = Arrays.stream(traders)
                .collect(Collectors.toMap(Trader::getName, Trader::getCity));
        System.out.println(traderMap);

        System.out.println("\nTASK: use the groupingBy() Method of Collectors to group transactions by traders ");
        Map<Trader, List<Transaction>> tradersGroupMap = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getTrader));

        tradersGroupMap.forEach((k,v) -> {
            System.out.println(k.getName() + " " + v);
        });
        //System.out.println(tradersGroupMap);

        System.out.println("\nTASK: use the groupingBy() Method of Collectors to group transactions by companies ");
        Map<String, List<Transaction>> byCompanies = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getCompany));

        byCompanies.forEach((k,v) -> {
            System.out.println(k+ ":");
            v.forEach(System.out::println);
        });

        System.out.println("\nTASK: use the groupingBy() Method of Collectors to group transactions by year ");
        Map<Integer, List<Transaction>> byYear = transactions.stream()
                .collect(Collectors.groupingBy(Transaction::getYear));

        byYear.forEach((k,v) -> {
            System.out.println(k+ ":");
            v.forEach(System.out::println);
        });





    }
}
