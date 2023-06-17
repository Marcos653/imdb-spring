package br.com.alura.dayscode.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class MovieServiceTest {

    @Mock
    private RestTemplate restTemplate;

    @InjectMocks
    private MovieService movieService;

    @Test
    public void shouldReturnTop250Movies() {
        String url = "https://imdb-api.com/en/API/Top250Movies/k_zn8y3r37";

        lenient().when(restTemplate.getForEntity(url, String.class))
                .thenReturn(ResponseEntity.ok().build());

        String response = movieService.getTopMovies();

        assertNotNull(response);
    }

}
