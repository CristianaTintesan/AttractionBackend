package disi2022.controllers;

import disi2022.converter.AttractionConverter;
import disi2022.dtos.AttractionDTO;
import disi2022.entities.Attraction;
import disi2022.services.AttractionService;
import disi2022.websocket.MessageDTO;
import disi2022.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/attraction")
@RequiredArgsConstructor
public class AttractionController {

    @Autowired
    SimpMessagingTemplate template;

    private final AttractionService attractionService;
    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<Collection<AttractionDTO>> getAttractions() {
        List<AttractionDTO> dtos = attractionService.getAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AttractionDTO> getAttraction(@PathVariable int id) {
        Attraction attraction = attractionService.getOne(id);
        AttractionDTO attractionDTO = AttractionConverter.attractionToDto(attraction);
        attractionDTO.setRating(reviewService.getAverageRatingForAttractionId(attraction.getId()));
        return new ResponseEntity<>(attractionDTO, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<AttractionDTO> addAttraction(@RequestBody AttractionDTO dto) {
        Attraction attraction = attractionService.add(AttractionConverter.dtoToAttraction(dto));
        //Send brodcast message to users
        String msg = Integer.toString(attraction.getId());
        template.convertAndSend("/topic/message", new MessageDTO(msg));

        return new ResponseEntity<>(AttractionConverter.attractionToDto(attraction), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<AttractionDTO> updateAttraction(@PathVariable int id, @RequestBody AttractionDTO dto) {
        dto.setId(id);
        Attraction attraction = attractionService.update(AttractionConverter.dtoToAttraction(dto));

        //Send brodcast message to users
        String msg = Integer.toString(attraction.getId());
        template.convertAndSend("/topic/message", new MessageDTO(msg));

        return new ResponseEntity<>(AttractionConverter.attractionToDto(attraction), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteAttraction(@PathVariable int id) {
        attractionService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }


}
