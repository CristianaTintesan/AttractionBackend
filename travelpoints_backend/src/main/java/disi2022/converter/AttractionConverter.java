package disi2022.converter;

import disi2022.dtos.AttractionDTO;
import disi2022.dtos.WishlistDTO;
import disi2022.entities.Attraction;

import java.util.List;
import java.util.stream.Collectors;

public class AttractionConverter {
    public static AttractionDTO attractionToDto(Attraction attraction) {

        return AttractionDTO.builder()
                .id(attraction.getId())
                .name(attraction.getName())
                .description(attraction.getDescription())
                .location(attraction.getLocation())
                .price(attraction.getPrice())
                .photoUrl(attraction.getPhotoUrl())
                .isWish(attraction.getIsWish())
                .build();
    }
    public static Attraction dtoToAttraction(AttractionDTO dto) {
        return Attraction.builder()
                .id(dto.getId())
                .name(dto.getName())
                .description(dto.getDescription())
                .location(dto.getLocation())
                .price(dto.getPrice())
                .photoUrl(dto.getPhotoUrl())
                .isWish(dto.getIsWish())
                .build();
    }
}
