package disi2022.dtos;


import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
public class UserDTO {
    private int id;
    private String lastName;
    private String firstName;
    private String username;
    private String password;
    private int role;
}
