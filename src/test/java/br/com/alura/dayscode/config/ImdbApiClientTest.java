package br.com.alura.dayscode.config;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
public class ImdbApiClientTest {

    @Mock
    private RestTemplate restTemplate;
    @InjectMocks
    private ImdbApiClient imdbApiClient;
    @Value("${imdb.apikey}")
    private String apiKey;

    @Test
    public void shouldReturnBody() {
        String expectedBody = "response body";
        ResponseEntity<String> responseEntity = ResponseEntity.ok(expectedBody);
        String url = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;
        when(restTemplate.getForEntity(any(String.class), eq(String.class))).thenReturn(responseEntity);

        String responseBody = imdbApiClient.getBody();

        assertEquals(expectedBody, responseBody);
        verify(restTemplate).getForEntity(any(String.class), eq(String.class));
    }
}
