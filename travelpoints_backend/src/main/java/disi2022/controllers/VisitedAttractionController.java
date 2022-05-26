package disi2022.controllers;

import disi2022.converter.VisitedAttractionConverter;
import disi2022.converter.VisitedAttractionConverter;
import disi2022.dtos.VisitedAttractionDTO;
import disi2022.dtos.VisitedAttractionDTO;
import disi2022.entities.VisitedAttraction;
import disi2022.services.AttractionService;
import disi2022.services.VisitedAttractionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/visitedAttraction")
@RequiredArgsConstructor
public class VisitedAttractionController {

    private final VisitedAttractionService visitedAttractionService;

    @GetMapping
    public ResponseEntity<Collection<VisitedAttractionDTO>> getVisitedAttractions() {
        List<VisitedAttractionDTO> dtos = visitedAttractionService.getAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitedAttractionDTO> getVisitedtAttraction(@PathVariable int id) {
        VisitedAttraction visitedAttraction = visitedAttractionService.getOne(id);
        return new ResponseEntity<>(VisitedAttractionConverter.visitedAttractionToDto(visitedAttraction), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<VisitedAttractionDTO> addVisitedAttraction(@RequestBody VisitedAttractionDTO dto) {
        VisitedAttraction visitedAttraction = visitedAttractionService.add(VisitedAttractionConverter.dtoToVisitedAttraction(dto));
        return new ResponseEntity<>(VisitedAttractionConverter.visitedAttractionToDto(visitedAttraction), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<VisitedAttractionDTO> updateVisitedAttraction(@PathVariable int id, @RequestBody VisitedAttractionDTO dto) {
        dto.setId(id);
        VisitedAttraction visitedAttraction = visitedAttractionService.update(VisitedAttractionConverter.dtoToVisitedAttraction(dto));
        return new ResponseEntity<>(VisitedAttractionConverter.visitedAttractionToDto(visitedAttraction), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteVisitedAttraction(@PathVariable int id) {
        visitedAttractionService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }
}
