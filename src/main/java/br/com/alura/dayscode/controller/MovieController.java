package br.com.alura.dayscode.controller;

import br.com.alura.dayscode.model.Movie;
import br.com.alura.dayscode.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class  MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/top-movies")
    public List<Movie> getTopMovies() throws JsonProcessingException {
        return movieService.getTopMovies();
    }

    @GetMapping("/top-movies-html")
    public ModelAndView getTopMoviesHtml() throws JsonProcessingException {
        return movieService.createMoviesModelAndView();
    }
}
