package com.example.SpringBootLab.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieController.class);
    List<Movie> movieList = new ArrayList<>();

    @GetMapping()
    public List<Movie> getAllMovies(){
        LOGGER.info("Returned list of movies");
        return movieList;
    }

    @GetMapping("/{id}")
    public Movie getMovieByID(@PathVariable int id){
        Movie movieByID = movieList
                .stream()
                .filter((movie) -> movie.getId() == id)
                .findFirst()
                .get();
        LOGGER.info("Movie {} {} {} {}", movieByID.getTitle(), movieByID.getCategory(), movieByID.getRating(), movieByID.getId());
        return movieByID;
    }

    @GetMapping("/search/findByCategory/{category}")
    public List<Movie> getMoviesByCategory(@PathVariable String category){
        List<Movie> moviesByCategory = movieList
                .stream()
                .filter((movie) -> movie.getCategory().equalsIgnoreCase(category))
                .collect(Collectors.toList());
        LOGGER.info("Returned movies by category");
        return moviesByCategory;
    }


    @PostMapping()
    public Movie createMovie(@RequestBody Movie request){
        LOGGER.info("Movie {} {} {} {}", request.getTitle(), request.getCategory(), request.getRating(), request.getId());
        movieList.add(request);
        return request;
    }

    @PutMapping("/{id}")
    public Movie updateMovie(@PathVariable int id, @RequestBody Movie request) {
        Movie movieByID = movieList
                .stream()
                .filter((movie) -> movie.getId() == id)
                .findFirst()
                .get();
        movieList.remove(movieByID);
        movieList.add(request);
        LOGGER.info("Movie {} {} {} {}", request.getTitle(), request.getCategory(), request.getRating(), request.getId());
        return request;
    }

    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable int id) {
        Movie movieByID = movieList
                .stream()
                .filter((movie) -> movie.getId() == id)
                .findFirst()
                .get();
        movieList.remove(movieByID);
        LOGGER.info("Deleted Movie");
    }
}
