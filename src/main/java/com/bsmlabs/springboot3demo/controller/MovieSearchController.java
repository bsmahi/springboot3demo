package com.bsmlabs.springboot3demo.controller;

import com.bsmlabs.springboot3demo.model.Movie;
import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieSearchController {

    private final ObservationRegistry registry;

    public MovieSearchController(ObservationRegistry registry) {
        this.registry = registry;
    }

    @GetMapping("/movie-search/{name}")
    Movie getMovie(@PathVariable String name) {
        var isValidName = StringUtils.hasText(name) && Character.isUpperCase(name.charAt(0));
        if (!isValidName) {
            throw new IllegalArgumentException("the name must be alphabets ");
        }

        return Observation.createNotStarted("movie-search.name", this.registry)
                .observe(() -> new Movie("Hello, " + name + "!"));
    }
}
