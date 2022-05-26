package disi2022.dtos;

import lombok.Data;

import java.util.List;

@Data
public class AttractionReviewsDTO {

    private int rating;
    private List<ReviewDTO> reviews;

}
