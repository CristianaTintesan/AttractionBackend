package disi2022.services;

import disi2022.converter.AttractionConverter;
import disi2022.converter.VisitedAttractionConverter;
import disi2022.dtos.AttractionDTO;
import disi2022.dtos.VisitedAttractionDTO;
import disi2022.entities.VisitedAttraction;
import disi2022.entities.VisitedAttraction;
import disi2022.exceptions.AttractionNotFoundException;
import disi2022.exceptions.VisitedAttractionNotFoundException;
import disi2022.repositories.AttractionRepository;
import disi2022.repositories.VisitedAttractionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class VisitedAttractionService {
    private final VisitedAttractionRepository visitedAttractionRepository;

    public List<VisitedAttractionDTO> getAll() {
        return visitedAttractionRepository.findAll().stream()
                .map(VisitedAttractionConverter::visitedAttractionToDto)
                .collect(Collectors.toList());
    }

    public VisitedAttraction getOne(int id) {
        return visitedAttractionRepository.findById(id).orElseThrow(() -> new VisitedAttractionNotFoundException(id));
    }

    public VisitedAttraction add(VisitedAttraction visitedAttraction) {
        return visitedAttractionRepository.save(visitedAttraction);
    }

    @Transactional
    public VisitedAttraction update(VisitedAttraction visitedAttraction) {
        Optional<VisitedAttraction> attractionOptionalInDb = visitedAttractionRepository.findById(visitedAttraction.getId());

        attractionOptionalInDb.ifPresent(
                attractionAux -> {
                    attractionAux.setTimestamp(visitedAttraction.getTimestamp());
                }
        );
        return attractionOptionalInDb.orElseThrow(() -> new VisitedAttractionNotFoundException(visitedAttraction.getId()));
    }

    @Transactional
    public void delete(int id) {
        visitedAttractionRepository.deleteById(id);
    }
}
