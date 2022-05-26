package disi2022.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
public class ReviewDTO {
    private int id;
    private String message;
    private int rating;
    private UserDTO user;
    private AttractionDTO attraction;

}
