package br.com.alura.dayscode.service;

import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class MovieService {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public void getTopMovies() {
        RestTemplate restTemplate = restTemplate();
        String url = "https://imdb-api.com/en/API/Top250Movies/k_zn8y3r37";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        System.out.println(response.getBody());
    }
}
