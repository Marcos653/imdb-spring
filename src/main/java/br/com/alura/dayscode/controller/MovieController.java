package br.com.alura.dayscode.controller;

import br.com.alura.dayscode.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @RequestMapping("/topMovies")
    public void getTopMovies() {
        movieService.getTopMovies();
    }
}
