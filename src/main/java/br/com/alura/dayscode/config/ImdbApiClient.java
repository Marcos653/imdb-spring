package br.com.alura.dayscode.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ImdbApiClient {

    private final String apiKey;
    private final RestTemplate restTemplate;

    @Autowired
    public ImdbApiClient(@Value("${imdb.apikey}") String apiKey, RestTemplate restTemplate) {
        this.apiKey = apiKey;
        this.restTemplate = restTemplate;
    }

    public String getBody() {
        String url = "https://imdb-api.com/en/API/Top250Movies/" + apiKey;
        return restTemplate.getForEntity(url, String.class).getBody();
    }
}
