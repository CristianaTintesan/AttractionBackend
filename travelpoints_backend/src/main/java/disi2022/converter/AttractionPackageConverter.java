package disi2022.converter;


import disi2022.dtos.AttractionPackageDTO;
import disi2022.entities.AttractionPackage;

public class AttractionPackageConverter {
    public static AttractionPackageDTO attractionPackageToDto(AttractionPackage attractionPackage) {
        return AttractionPackageDTO.builder()
                .id(attractionPackage.getId())
                .total_price(attractionPackage.getTotal_price())
                .attraction(AttractionConverter.attractionToDto(attractionPackage.getAttraction()))
                .build();
    }
    public static AttractionPackage dtoToAttractionPackage(AttractionPackageDTO dto) {
        return AttractionPackage.builder()
                .id(dto.getId())
                .total_price(dto.getTotal_price())
                .attraction(AttractionConverter.dtoToAttraction(dto.getAttraction()))
                .build();
    }
}
