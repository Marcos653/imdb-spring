package br.com.alura.dayscode.dto;

import br.com.alura.dayscode.model.Movie;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import static java.util.Optional.ofNullable;

@JsonIgnoreProperties(ignoreUnknown = true)
public record MovieDto(
        String title,
        String image,
        String imDbRating,
        String year
) {

    public static Movie of(MovieDto movieDto) {
        Movie movie = new Movie();

        movie.setTitle(ofNullable(movieDto.title).orElse(""));
        movie.setUrlImage(ofNullable(movieDto.image).orElse(""));
        movie.setRating(ofNullable(movieDto.imDbRating).map(Double::valueOf).orElse(null));
        movie.setYear(ofNullable(movieDto.year).map(Integer::valueOf).orElse(null));

        return movie;
    }
}
