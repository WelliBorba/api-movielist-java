package br.com.api.movielistjava.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class WinnerDTO {

    public WinnerDTO(String producer, Integer interval, Integer previousWin, Integer followingWin) {
        super();
        this.producer = producer;
        this.interval = interval;
        this.previousWin = previousWin;
        this.followingWin = followingWin;
    }

    private String producer;
    private Integer interval;
    private Integer previousWin;
    private Integer followingWin;

}
