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

import java.util.List;

@Service
public class MovieService {

    private final ImdbApiClient client;
    private final ObjectMapper mapper;

    @Autowired
    public MovieService(ImdbApiClient client, ObjectMapper mapper) {
        this.client = client;
        this.mapper = mapper;
    }

    public List<Movie> getTopMovies() throws JsonProcessingException {
        List<MovieDto> movieDtoList = fetchTopMovies();
        return convertToMovies(movieDtoList);
    }

    private List<MovieDto> fetchTopMovies() throws JsonProcessingException {
        String responseBody = client.getBody();
        JsonNode root = mapper.readTree(responseBody);
        JsonNode itemsNode = root.get("items");

        return mapper.readValue(itemsNode.toString(), new TypeReference<List<MovieDto>>(){});
    }

     private List<Movie> convertToMovies(List<MovieDto> movieDtoList) {
        return movieDtoList.stream()
                .map(MovieDto::of)
                .toList();
    }

    public ModelAndView createMoviesModelAndView() throws JsonProcessingException {
        ModelAndView modelAndView = new ModelAndView("Movies");
        modelAndView.addObject("movies", getTopMovies());
        return modelAndView;
    }
}
