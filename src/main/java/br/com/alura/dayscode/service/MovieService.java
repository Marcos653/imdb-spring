package br.com.alura.dayscode.service;

import br.com.alura.dayscode.dto.MovieDto;
import br.com.alura.dayscode.model.Movie;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public List<Movie> getTopMovies() throws JsonProcessingException {
        RestTemplate restTemplate = restTemplate();
        String url = "https://imdb-api.com/en/API/Top250Movies/k_zn8y3r37";

        ResponseEntity<String> response = restTemplate.getForEntity(url, String.class);

        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(response.getBody());

        JsonNode itemsNode = root.get("items");
        List<MovieDto> movieDtoList = mapper.readValue(
                itemsNode.toString(),
                new TypeReference<List<MovieDto>>(){});

        return movieDtoList.stream()
                .map(MovieDto::of)
                .toList();
    }
}
