package hello;

import hello.model.Movie;
import hello.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private MovieService movieService;

    @RequestMapping("/")
    public String index() {
        List< Movie > starWarsQuery = movieService.getByName("Star Wars");
        return "Content of star wars name query is " + starWarsQuery.toString();
    }
}
