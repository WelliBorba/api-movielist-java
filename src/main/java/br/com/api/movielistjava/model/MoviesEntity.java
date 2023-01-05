package br.com.api.movielistjava.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "MOVIES")
@NoArgsConstructor
public class MoviesEntity {

    public MoviesEntity(Integer year, String title, String studios, String producer, Boolean winner) {
        super();
        this.year = year;
        this.title = title;
        this.studios = studios;
        this.producer = producer;
        this.winner = winner;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private Integer id;
    @Column(name = "YEARS")
    private Integer year;
    @Column(name = "TITLE")
    private String title;
    @Column(name = "STUDIOS")
    private String studios;
    @Column(name = "PRODUCER")
    private String producer;
    @Column(name = "WINNER")
    private Boolean winner;
}
