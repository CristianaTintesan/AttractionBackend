package disi2022.services;

import disi2022.converter.AttractionConverter;
import disi2022.dtos.AttractionDTO;
import disi2022.entities.Attraction;
import disi2022.exceptions.AttractionNotFoundException;
import disi2022.repositories.AttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttractionService {
    private final AttractionRepository attractionRepository;
    private final ReviewService reviewService;

    public List<AttractionDTO> getAll() {
        return attractionRepository.findAll().stream()
                .map(attraction -> {
                    AttractionDTO attractionDTO = AttractionConverter.attractionToDto(attraction);
                    attractionDTO.setRating(reviewService.getAverageRatingForAttractionId(attraction.getId()));

                    return attractionDTO;
                })
                .collect(Collectors.toList());
    }

    public Attraction getOne(int id) {
        return attractionRepository.findById(id).orElseThrow(() -> new AttractionNotFoundException(id));
    }

    public Attraction add(Attraction attraction) {
        return attractionRepository.save(attraction);
    }

    @Transactional
    public Attraction update(Attraction attraction) {
        Optional<Attraction> attractionOptionalInDb = attractionRepository.findById(attraction.getId());

        attractionOptionalInDb.ifPresent(
                attractionAux -> {
                    attractionAux.setName(attraction.getName());
                    attractionAux.setDescription(attraction.getDescription());
                    attractionAux.setLocation(attraction.getLocation());
                    attractionAux.setPrice(attraction.getPrice());
                    attractionAux.setPhotoUrl(attraction.getPhotoUrl());
                    attractionAux.setWish(attraction.getIsWish());
                }
        );
        return attractionOptionalInDb.orElseThrow(() -> new AttractionNotFoundException(attraction.getId()));
    }

    @Transactional
    public void delete(int id) {
        attractionRepository.deleteById(id);
    }
}
