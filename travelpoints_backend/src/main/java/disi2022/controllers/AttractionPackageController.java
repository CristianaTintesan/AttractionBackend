package disi2022.controllers;


import disi2022.converter.AttractionPackageConverter;
import disi2022.dtos.AttractionPackageDTO;
import disi2022.entities.AttractionPackage;
import disi2022.services.AttractionPackageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/attractionPackage")
@RequiredArgsConstructor
public class AttractionPackageController {

    private final AttractionPackageService attractionPackageService;

    @GetMapping
    public ResponseEntity<Collection<AttractionPackageDTO>> getAttractionPackages() {
        List<AttractionPackageDTO> dtos = attractionPackageService.getAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttractionPackageDTO> getAttractionPackage(@PathVariable int id) {
        AttractionPackage attractionPackage = attractionPackageService.getOne(id);
        return new ResponseEntity<>(AttractionPackageConverter.attractionPackageToDto(attractionPackage), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AttractionPackageDTO> addAttractionPackage(@RequestBody AttractionPackageDTO dto) {
        AttractionPackage attractionPackage = attractionPackageService.add(AttractionPackageConverter.dtoToAttractionPackage(dto));
        return new ResponseEntity<>(AttractionPackageConverter.attractionPackageToDto(attractionPackage), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttractionPackageDTO> updateAttractionPackage(@PathVariable int id, @RequestBody AttractionPackageDTO dto) {
        dto.setId(id);
        AttractionPackage attractionPackage = attractionPackageService.update(AttractionPackageConverter.dtoToAttractionPackage(dto));
        return new ResponseEntity<>(AttractionPackageConverter.attractionPackageToDto(attractionPackage), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteAttractionPackage(@PathVariable int id) {
        attractionPackageService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

}
