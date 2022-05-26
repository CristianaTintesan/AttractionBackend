package disi2022.converter;

import disi2022.dtos.VisitedAttractionDTO;
import disi2022.entities.VisitedAttraction;


public class VisitedAttractionConverter {
    public static VisitedAttractionDTO visitedAttractionToDto(VisitedAttraction visitedAttraction) {
        return VisitedAttractionDTO.builder()
                .id(visitedAttraction.getId())
                .timestamp(visitedAttraction.getTimestamp())
                .attraction(AttractionConverter.attractionToDto(visitedAttraction.getAttraction()))
                .build();
    }
    public static VisitedAttraction dtoToVisitedAttraction(VisitedAttractionDTO dto) {
        return VisitedAttraction.builder()
                .id(dto.getId())
                .timestamp(dto.getTimestamp())
                .attraction(AttractionConverter.dtoToAttraction(dto.getAttraction()))
                .build();
    }
}
