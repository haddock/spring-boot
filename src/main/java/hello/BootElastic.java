package hello;

import hello.model.Genre;
import hello.model.Movie;
import hello.service.MovieService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fredrik.bergljung on 2015-12-10.
 */
@Configuration
@EnableAutoConfiguration
@ComponentScan
public class BootElastic implements CommandLineRunner {

    @Autowired
    private MovieService movieService;

    private static final Logger logger = LoggerFactory.getLogger(BootElastic.class);

    private void addSomeMovies() {
        Movie starWars = getFirstMovie();
        movieService.addMovie(starWars);

        Movie princessBride = getSecondMovie();
        movieService.addMovie(princessBride);
    }

    private Movie getFirstMovie() {
        Movie firstMovie = new Movie();
        firstMovie.setId(1);
        firstMovie.setRating(9.6d);
        firstMovie.setName("Star Wars");

        List<Genre> starWarsGenre = new ArrayList<Genre>();
        starWarsGenre.add(new Genre("ACTION"));
        starWarsGenre.add(new Genre("SCI_FI"));
        firstMovie.setGenre(starWarsGenre);

        return firstMovie;
    }

    private Movie getSecondMovie() {
        Movie secondMovie = new Movie();
        secondMovie.setId(2);
        secondMovie.setRating(8.4d);
        secondMovie.setName("The Princess Bride");

        List<Genre> princessBrideGenre = new ArrayList<Genre>();
        princessBrideGenre.add(new Genre("ACTION"));
        princessBrideGenre.add(new Genre("ROMANCE"));
        secondMovie.setGenre(princessBrideGenre);

        return secondMovie;
    }

    public void run(String... args) throws Exception {
        addSomeMovies();

        List<Movie> starWarsQuery = movieService.getByName("Star Wars");
        logger.info("Content of star wars name query is {}", starWarsQuery);

        List<Movie> brideQuery = movieService.getByName("The Princess Bride");
        logger.info("Content of princess bride name query is {}", brideQuery);

        List<Movie> byRatingInterval = movieService.getByRatingInterval(6d, 9d);
        logger.info("Content of rating interval query is {}", byRatingInterval);

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(BootElastic.class, args);
    }
}
