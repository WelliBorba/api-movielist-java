package br.com.api.movielistjava.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WinnersDTO {

    public WinnersDTO(List<WinnerDTO> min, List<WinnerDTO> max) {
        this.min = min;
        this.max = max;
    }

    private List<WinnerDTO> min;
    private List<WinnerDTO> max;

}
