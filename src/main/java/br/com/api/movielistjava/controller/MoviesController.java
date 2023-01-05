package br.com.api.movielistjava.controller;

import br.com.api.movielistjava.model.MoviesEntity;
import br.com.api.movielistjava.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/api"})
public class MoviesController {

    @Autowired
    private MovieService movieService;

    @GetMapping()
    public ResponseEntity get() {
        return movieService.get();
    }

    @GetMapping({"/awards"})
    public ResponseEntity getAwards() {
        return movieService.getAwards();
    }

    @GetMapping({"/winners"})
    public ResponseEntity getWinners() {
        return movieService.getWinners();
    }

    @PostMapping()
    public ResponseEntity post(@RequestBody MoviesEntity movie) {
        movieService.post(movie);
        return ResponseEntity.status(201).build();
    }
    @DeleteMapping()
    public ResponseEntity delete(@RequestBody MoviesEntity movie) {
        movieService.delete(movie);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping({"/{id}"})
    public ResponseEntity delete(@PathVariable(value = "id") Integer id) {
        movieService.delete(id);
        return ResponseEntity.ok().build();
    }

    @PutMapping()
    public ResponseEntity put(@RequestBody MoviesEntity movie) {
        return movieService.put(movie);
    }

}
