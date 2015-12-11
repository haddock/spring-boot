package hello.dao;

import hello.model.Movie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * Created by fredrik.bergljung on 2015-12-10.
 */
public interface MovieRepository extends ElasticsearchRepository<Movie, Long> {
    List<Movie> findByName(String name);
    List<Movie> findByRatingBetween(Double beginning, Double end);
}
