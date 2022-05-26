package disi2022.converter;

import disi2022.dtos.UserDTO;
import disi2022.dtos.WishlistDTO;
import disi2022.entities.User;
import disi2022.enums.UserRole;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class UserConverter {
    public static UserDTO userToDto(User user) {
        return UserDTO.builder()
                .id(user.getId())
                .lastName(user.getLastName())
                .firstName(user.getFirstName())
                .username(user.getUsername())
                .password(user.getPassword())
                .role(user.getRole().ordinal())
                .build();
    }

    public static User dtoToUser(UserDTO dto) {
        return User.builder()
                .id(dto.getId())
                .lastName(dto.getLastName())
                .firstName(dto.getFirstName())
                .username(dto.getUsername())
                .password(dto.getPassword())
                .role(dto.getRole()==0 ? UserRole.ADMIN : UserRole.TOURIST)
                .build();
    }
}
