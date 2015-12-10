package hello.service;

import hello.dao.MovieRepository;
import hello.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fredrik.bergljung on 2015-12-10.
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository repository;

    public List<Movie> getByName(String name) {
        return repository.findByName(name);
    }

    public List<Movie> getByRatingInterval(Double beginning, Double end) {
        return repository.findByRatingBetween(beginning, end);
    }

    public void addMovie(Movie movie) {
        repository.save(movie);
    }
}
