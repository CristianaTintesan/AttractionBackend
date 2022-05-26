package disi2022.services;

import disi2022.converter.AttractionPackageConverter;
import disi2022.dtos.AttractionPackageDTO;
import disi2022.entities.Attraction;
import disi2022.entities.AttractionPackage;
import disi2022.exceptions.AttractionNotFoundException;
import disi2022.exceptions.AttractionPackageNotFoundException;
import disi2022.repositories.AttractionPackageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttractionPackageService {
    private final AttractionPackageRepository attractionPackageRepository;

    public List<AttractionPackageDTO> getAll() {
        return attractionPackageRepository.findAll().stream()
                .map(AttractionPackageConverter::attractionPackageToDto)
                .collect(Collectors.toList());
    }

    public AttractionPackage getOne(int id) {
        return attractionPackageRepository.findById(id).orElseThrow(() -> new AttractionPackageNotFoundException(id));
    }

    public AttractionPackage add(AttractionPackage attractionPackage) {
        return attractionPackageRepository.save(attractionPackage);
    }

    @Transactional
    public AttractionPackage update(AttractionPackage attractionPackage) {
        Optional<AttractionPackage> attractionOptionalInDb = attractionPackageRepository.findById(attractionPackage.getId());

        attractionOptionalInDb.ifPresent(
                attractionAux -> {
                    attractionAux.setTotal_price(attractionPackage.getTotal_price());
                }
        );
        return attractionOptionalInDb.orElseThrow(() -> new AttractionNotFoundException(attractionPackage.getId()));
    }

    @Transactional
    public void delete(int id) {
        attractionPackageRepository .deleteById(id);
    }
}
