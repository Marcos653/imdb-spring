package br.com.alura.dayscode.controller;

import br.com.alura.dayscode.model.Movie;
import br.com.alura.dayscode.service.MovieService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/top-movies-html")
    public ModelAndView getTopMoviesHtml(@RequestParam(required = false) String title) throws JsonProcessingException {
        return movieService.createMoviesModelAndView(title);
    }

    @GetMapping("/history-html")
    public ModelAndView getHistoryMoviesHtml() throws JsonProcessingException {
        return movieService.getHistoryMoviesModelAndView();
    }

    @GetMapping("/my-favorite-movies-html")
    public ModelAndView getFavoriteMoviesHtml() {
        return movieService.getFavoriteMoviesModelAndView();
    }

    @GetMapping("/top-movies")
    public List<Movie> getTopMovies(@RequestParam(required = false) String title) throws JsonProcessingException {
        return movieService.getTopMovies(title);
    }

    @PostMapping("/favorite/{movieId}")
    public ModelAndView addFavoriteMoveis(@PathVariable Long movieId) {
        return movieService.addFavoriteMoviesModelAndView(movieId);
    }

    @GetMapping("/my-favorite-movies")
    public List<Movie> getFavoriteMovies() {
        return movieService.getFavoriteMovies();
    }

    @GetMapping("/history")
    public List<Movie> getHistoryMovies() {
        return movieService.getHistoryMovies();
    }
}
