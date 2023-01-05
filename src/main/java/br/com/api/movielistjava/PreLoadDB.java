package br.com.api.movielistjava;

import br.com.api.movielistjava.model.MoviesEntity;
import br.com.api.movielistjava.repository.MoviesRepository;
import com.opencsv.CSVParser;
import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import com.opencsv.exceptions.CsvException;
import org.apache.commons.lang3.BooleanUtils;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class PreLoadDB {

    MoviesRepository moviesRepository;
    public PreLoadDB(MoviesRepository moviesRepository) {
        super();
        this.moviesRepository = moviesRepository;
    }

    public void startDB() {
        try {
            Reader reader = null;
            reader = Files.newBufferedReader(Paths.get("movielist.csv"));
            CSVParser parser = new CSVParserBuilder().withSeparator(';').build();
            CSVReader csvReader = new CSVReaderBuilder(reader).withCSVParser(parser).withSkipLines(1).build();

            List<String[]> movies = csvReader.readAll();

            for (String[] movie : movies) {
                String[] producers = movie[3].replace("and", ",").split(",");

                for (String producer : producers) {
                    if (!producer.trim().isEmpty()) {
                        MoviesEntity moviesEntity = new MoviesEntity(Integer.valueOf(movie[0]), movie[1], movie[2],
                                producer.trim(), BooleanUtils.toBoolean(movie[4]));

                        moviesRepository.save(moviesEntity);
                    }
                }
            }
        } catch (IOException | CsvException ex) {
            throw new RuntimeException(ex);
        }
    }
}
