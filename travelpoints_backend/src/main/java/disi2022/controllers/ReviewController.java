package disi2022.controllers;

import disi2022.converter.ReviewConverter;
import disi2022.dtos.AttractionReviewsDTO;
import disi2022.dtos.ReviewDTO;
import disi2022.entities.Review;
import disi2022.services.ReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "/review")
@RequiredArgsConstructor
public class ReviewController {

    private final ReviewService reviewService;

    @GetMapping
    public ResponseEntity<Collection<ReviewDTO>> getReviews() {
        List<ReviewDTO> dtos = reviewService.getAll();
        return new ResponseEntity<>(dtos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDTO> getReview(@PathVariable int id) {
        Review review = reviewService.getOne(id);
        return new ResponseEntity<>(ReviewConverter.reviewToDto(review), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<ReviewDTO> addReview(@RequestBody ReviewDTO dto) {
        Review review = reviewService.add(ReviewConverter.dtoToReview(dto));
        return new ResponseEntity<>(ReviewConverter.reviewToDto(review), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDTO> updateReview(@PathVariable int id, @RequestBody ReviewDTO dto) {
        dto.setId(id);
        Review review = reviewService.update(ReviewConverter.dtoToReview(dto));
        return new ResponseEntity<>(ReviewConverter.reviewToDto(review), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Integer> deleteReview(@PathVariable int id) {
        reviewService.delete(id);
        return new ResponseEntity<>(id, HttpStatus.OK);
    }

    @GetMapping("/attraction/{id}")
    public ResponseEntity<List<ReviewDTO>> getForAttractionId(@PathVariable Integer id) {
        return ResponseEntity.ok(reviewService.getAllForAttractionId(id));
    }
}
