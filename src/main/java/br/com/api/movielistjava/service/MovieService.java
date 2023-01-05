package br.com.api.movielistjava.service;

import br.com.api.movielistjava.dto.WinnerDTO;
import br.com.api.movielistjava.dto.WinnersDTO;
import br.com.api.movielistjava.model.MoviesEntity;
import br.com.api.movielistjava.repository.MoviesRepository;
import org.apache.commons.lang3.BooleanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MovieService {

    @Autowired
    private MoviesRepository moviesRepository;

    public ResponseEntity<List<MoviesEntity>> get() {
        try {
            if (moviesRepository.count() > 0) {
                return ResponseEntity.ok().body(moviesRepository.findAll());
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    public ResponseEntity<List<MoviesEntity>> getAwards() {
        try {
            List<MoviesEntity> listMovies = moviesRepository.findByWinner(true);
            if (!listMovies.isEmpty()) {
                return ResponseEntity.ok().body(listMovies);
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    public ResponseEntity<WinnersDTO> getWinners() {
        try {
            List<MoviesEntity> listMovies = moviesRepository.findByWinnerOrderByYear(true);

            if (!listMovies.isEmpty()) {
                Collections.sort(listMovies, new Comparator<MoviesEntity>() {
                    @Override
                    public int compare(MoviesEntity  m1, MoviesEntity  m2)
                    {
                        return  m1.getProducer().compareTo(m2.getProducer());
                    }
                });

                List minProd = new ArrayList();
                List maxProd = new ArrayList();
                String currentProd = "";
                Integer currentYear = 0;
                Integer currentInterval;
                Integer currentIntervalMin = 999999;
                Integer currentIntervalMax = 0;


                for (MoviesEntity movies : listMovies) {

                    if (movies.getProducer() == currentProd) {
                        currentInterval = movies.getYear() - currentYear;

                        if (currentInterval == currentIntervalMax) {
                            currentIntervalMax = currentInterval;
                            maxProd.add(new WinnerDTO(movies.getProducer(), currentIntervalMax, currentYear, movies.getYear()));
                        }

                        if (currentInterval > currentIntervalMax) {
                            currentIntervalMax = currentInterval;
                            maxProd = new ArrayList();
                            maxProd.add(new WinnerDTO(movies.getProducer(), currentIntervalMax, currentYear, movies.getYear()));
                        }

                        if (currentInterval == currentIntervalMin) {
                            currentIntervalMin = currentInterval;
                            minProd.add(new WinnerDTO(movies.getProducer(), currentIntervalMin, currentYear, movies.getYear()));
                        }

                        if (currentInterval < currentIntervalMin) {
                            currentIntervalMin = currentInterval;
                            minProd = new ArrayList();
                            minProd.add(new WinnerDTO(movies.getProducer(), currentIntervalMin, currentYear, movies.getYear()));
                        }
                    }
                    currentProd = movies.getProducer();
                    currentYear = movies.getYear();
                };

                return ResponseEntity.ok().body(new WinnersDTO(minProd, maxProd));
            } else {
                return ResponseEntity.status(404).build();
            }
        } catch (Exception e) {
            return ResponseEntity.status(400).build();
        }
    }

    public void post(MoviesEntity movie) {
        for (String producer : movie.getProducer().replace("and", ",").split(",")) {
            MoviesEntity moviesEntity = new MoviesEntity(movie.getYear(), movie.getTitle(), movie.getStudios(),
                    producer.trim(), BooleanUtils.toBoolean(movie.getWinner()));

            moviesRepository.save(moviesEntity);

        }
    }

    public void delete(MoviesEntity movie) {
        moviesRepository.delete(movie);
    }

    public void delete(Integer id) {
        moviesRepository.deleteById(id);
    }

    public ResponseEntity<MoviesEntity> put(MoviesEntity movie) {
        moviesRepository.save(movie);
        return ResponseEntity.ok().body(movie);
    }
}
