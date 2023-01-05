package br.com.api.movielistjava;

import br.com.api.movielistjava.repository.MoviesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class ApiMovielistJavaApplication implements CommandLineRunner {
	@Autowired
	private MoviesRepository moviesRepository;
	public static void main(String[] args) {
		SpringApplication.run(ApiMovielistJavaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		PreLoadDB preLoadDB = new PreLoadDB(moviesRepository);
		preLoadDB.startDB();
	}
}
