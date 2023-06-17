package br.com.alura.dayscode.service;

import br.com.alura.dayscode.model.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.lenient;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void shouldReturnTop250Movies() throws JsonProcessingException {
        String url = "https://imdb-api.com/en/API/Top250Movies/k_zn8y3r37";

        lenient().when(restTemplate.getForEntity(url, String.class))
                .thenReturn(ResponseEntity.ok().build());

        List<Movie> response = movieService.getTopMovies();

        assertNotNull(response);
    }

}
