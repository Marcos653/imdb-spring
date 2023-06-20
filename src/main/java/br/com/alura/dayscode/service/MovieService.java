package br.com.alura.dayscode.service;

import br.com.alura.dayscode.config.ImdbApiClient;
import br.com.alura.dayscode.dto.MovieDto;
import br.com.alura.dayscode.model.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private final ImdbApiClient client;
    private final ObjectMapper mapper;
    private final List<Movie> movies;
    private long idCounter;

    @Autowired
    public MovieService(ImdbApiClient client, ObjectMapper mapper) {
        this.client = client;
        this.mapper = mapper;
        this.movies = new ArrayList<>();
        this.idCounter = 1;
    }

    public List<Movie> getTopMovies(String title) throws JsonProcessingException {
        if (movies.isEmpty()) {
            fetchAndPopulateMovies();
        }

        List<Movie> filteredMovies = new ArrayList<>(movies);

        if (title != null) {
            filterMovies(filteredMovies, title);
        }

        return filteredMovies;
    }

    private void fetchAndPopulateMovies() throws JsonProcessingException {
        List<MovieDto> movieDtoList = fetchTopMovies();
        movies.addAll(convertToMovies(movieDtoList));
    }

    private void filterMovies(List<Movie> movies, String title) {
        movies.removeIf(movie -> !movie.getTitle().contains(title));
    }

    private List<MovieDto> fetchTopMovies() throws JsonProcessingException {
        String responseBody = client.getBody();
        JsonNode root = mapper.readTree(responseBody);
        JsonNode itemsNode = root.get("items");

        return mapper.readValue(itemsNode.toString(), new TypeReference<List<MovieDto>>() {
        });
    }

    private List<Movie> convertToMovies(List<MovieDto> movieDtoList) {
        return movieDtoList.stream()
                .map(movieDto -> {
                    Movie movie = MovieDto.of(movieDto);
                    movie.setId(idCounter++);
                    return movie;
                })
                .toList();
    }

    public ModelAndView createMoviesModelAndView(String title) throws JsonProcessingException {
        List<Movie> filteredMovies = getTopMovies(title);
        ModelAndView modelAndView = new ModelAndView("Movies");
        modelAndView.addObject("movies", filteredMovies);
        return modelAndView;
    }
}
