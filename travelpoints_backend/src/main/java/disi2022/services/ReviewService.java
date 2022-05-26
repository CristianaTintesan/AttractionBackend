package disi2022.services;

import disi2022.converter.ReviewConverter;
import disi2022.dtos.AttractionDTO;
import disi2022.dtos.AttractionReviewsDTO;
import disi2022.dtos.ReviewDTO;
import disi2022.entities.Attraction;
import disi2022.entities.Review;
import disi2022.exceptions.ReviewNotFoundException;
import disi2022.repositories.AttractionRepository;
import disi2022.repositories.ReviewRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewService {

    private final ReviewRepository reviewRepository;

    public List<ReviewDTO> getAll() {
        return reviewRepository.findAll().stream()
                .map(ReviewConverter::reviewToDto)
                .collect(Collectors.toList());
    }

    public Review getOne(int id) {
        return reviewRepository.findById(id).orElseThrow(() -> new ReviewNotFoundException(id));
    }

    public Review add(Review review) {
        return reviewRepository.save(review);
    }

    @Transactional
    public Review update(Review review) {
        Optional<Review> reviewOptionalInDb = reviewRepository.findById(review.getId());

        reviewOptionalInDb.ifPresent(
                reviewAux -> {
                    reviewAux.setMessage(review.getMessage());
                }
        );
        return reviewOptionalInDb.orElseThrow(() -> new ReviewNotFoundException(review.getId()));
    }

    @Transactional
    public void delete(int id) {
        reviewRepository.deleteById(id);
    }

    public List<ReviewDTO> getAllForAttractionId(Integer attractionId) {
        return reviewRepository.findAllByAttractionId(attractionId).stream()
                .map(review -> ReviewDTO.builder()
                        .id(review.getId())
                        .message(review.getMessage())
                        .rating(review.getRating())
                        .build()
                ).collect(Collectors.toList());
    }

    public int getAverageRatingForAttractionId(Integer attractionId) {
        Integer averageRating = reviewRepository.findAverageRatingForAttractionId(attractionId);

        return averageRating != null ? averageRating : 0;
    }
}
