package disi2022.dtos;

import lombok.*;
import lombok.experimental.SuperBuilder;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@SuperBuilder
@ToString
public class ResetPasswordDTO {
    String username;
    String oldPassword;
    String newPassword;
}
