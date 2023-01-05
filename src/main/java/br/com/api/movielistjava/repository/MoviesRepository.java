package br.com.api.movielistjava.repository;

import br.com.api.movielistjava.model.MoviesEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MoviesRepository extends JpaRepository <MoviesEntity, Integer> {

    List<MoviesEntity> findByWinner(boolean winner);

    List<MoviesEntity> findByWinnerOrderByYear(boolean winner);

}
