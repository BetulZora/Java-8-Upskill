package day3_comparator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class MovieRunner {

    public static void main(String[] args) {


        List<Movie> movies = new ArrayList<>(Arrays.asList(
                new Movie("Star Wars: Episode IV – A New Hope", 1977, 8.6),
                new Movie("Avatar", 2009, 7.9),
                new Movie("Iron Man", 2008, 7.9),
                new Movie("The Dark Knight", 2008, 9.0),
                new Movie("Rocky", 1976, 8.1)
        ));

        //print all the starting Movie data
        movies.forEach(System.out::println);

        //sort by year in ascending order
        System.out.println("Sorted Based On Year:");
        // movies.sort(Comparator.comparing(movie -> movie.getYear())); //lamda
        movies.sort(Comparator.comparing(Movie::getYear)); // method reference
        movies.forEach(System.out::println);

        //sort by year in descending order
        System.out.println("Sorted Based On Year: Descending");
        movies.sort(Comparator.comparing(Movie::getYear).reversed()); // method reference
        movies.forEach(System.out::println);

        //sort by the highest rated movie
        System.out.println("Sorted Based On RATING: Descending");
        movies.sort(Comparator.comparing(Movie::getRating).reversed());

        movies.forEach(System.out::println);

        //sort the names alphabetically
        System.out.println("Sorted Based On Name:");
        movies.sort(Comparator.comparing(Movie::getName));
        movies.forEach(System.out::println);



    }

}


/*	    perform the following actions:
	    	print all the starting Movie data
	    	sort by year in ascending order
	    	sort by year in descending order
	    	sort by the highest rated movie
	    	sort the names alphabetically

 */