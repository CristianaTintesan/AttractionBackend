package disi2022.dtos;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder

public class VisitedAttractionDTO {

    private int id;
    private Date timestamp;
    private AttractionDTO attraction;

}
