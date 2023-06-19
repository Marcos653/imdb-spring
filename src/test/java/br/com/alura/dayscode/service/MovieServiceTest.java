package br.com.alura.dayscode.service;

import br.com.alura.dayscode.config.ImdbApiClient;
import br.com.alura.dayscode.dto.MovieDto;
import br.com.alura.dayscode.model.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static br.com.alura.dayscode.helper.ImdbApiClientHelper.responseBodyImdb;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private ImdbApiClient imdbApiClient;

    @Mock
    private ObjectMapper objectMapper;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void shouldReturnTop250Movies() throws Exception {
        String responseBody = responseBodyImdb();
        JsonNode root = new ObjectMapper().readTree(responseBody);
        List<MovieDto> movieDtoList = new ArrayList<>();

        movieDtoList.add(new MovieDto("Movie 1", "image1.jpg", "8.5", "2021"));
        movieDtoList.add(new MovieDto("Movie 2", "image2.jpg", "7.9", "2022"));

        when(imdbApiClient.getBody()).thenReturn(responseBody);
        when(objectMapper.readTree(responseBody)).thenReturn(root);
        when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class))).thenReturn(movieDtoList);

        List<Movie> response = movieService.getTopMovies();

        assertNotNull(response);
        assertEquals(2, response.size());
        assertEquals("Movie 1", response.get(0).getTitle());
        assertEquals("image1.jpg", response.get(0).getUrlImage());
        assertEquals(8.5, response.get(0).getRating());
        assertEquals(2021, response.get(0).getYear());
        assertEquals("Movie 2", response.get(1).getTitle());
        assertEquals("image2.jpg", response.get(1).getUrlImage());
        assertEquals(7.9, response.get(1).getRating());
        assertEquals(2022, response.get(1).getYear());
    }

    @Test
    public void shouldCreateMoviesModelAndView() throws JsonProcessingException {
        List<MovieDto> movieDtoList = new ArrayList<>();
        movieDtoList.add(new MovieDto("Movie 1", "image1.jpg", "8.5", "2021"));
        movieDtoList.add(new MovieDto("Movie 2", "image2.jpg", "7.9", "2022"));

        List<Movie> expectedMovies = new ArrayList<>();
        expectedMovies.add(new Movie("Movie 1", "image1.jpg", 8.5, 2021));
        expectedMovies.add(new Movie("Movie 2", "image2.jpg", 7.9, 2022));

        when(imdbApiClient.getBody()).thenReturn("responseBody");

        JsonNode itemsNode = Mockito.mock(JsonNode.class);

        when(objectMapper.readTree(Mockito.anyString())).thenReturn(Mockito.mock(JsonNode.class));
        when(objectMapper.readValue(Mockito.anyString(), Mockito.any(TypeReference.class))).thenReturn(movieDtoList);
        when(objectMapper.readTree("responseBody").get("items")).thenReturn(itemsNode);
        when(itemsNode.toString()).thenReturn(movieDtoList.toString());

        ModelAndView modelAndView = movieService.createMoviesModelAndView();

        assertNotNull(modelAndView);
        assertEquals("Movies", modelAndView.getViewName());
    }
}
