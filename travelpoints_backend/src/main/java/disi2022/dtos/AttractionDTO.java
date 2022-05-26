package disi2022.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

public class AttractionDTO {
    private int id;
    private String name;
    private String description;
    private String location;
    private double price;
    private String photoUrl;
    private boolean isWish;
    public int rating;

    public void setWish(boolean wish) {
        isWish = wish;
    }
    public boolean getIsWish() {
        return isWish;
    }




}
