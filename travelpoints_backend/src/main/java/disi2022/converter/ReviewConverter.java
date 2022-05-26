package disi2022.converter;

import disi2022.dtos.ReviewDTO;
import disi2022.entities.Review;

public class ReviewConverter {
    public static ReviewDTO reviewToDto(Review review) {
        return ReviewDTO.builder()
                .id(review.getId())
                .message(review.getMessage())
                .rating(review.getRating())
                .attraction(AttractionConverter.attractionToDto(review.getAttraction()))
                .user(UserConverter.userToDto(review.getUser()))
                .build();
    }
    public static Review dtoToReview(ReviewDTO dto) {
        return Review.builder()
                .id(dto.getId())
                .message(dto.getMessage())
                .rating(dto.getRating())
                .attraction(AttractionConverter.dtoToAttraction(dto.getAttraction()))
                .user(UserConverter.dtoToUser(dto.getUser()))
                .build();
    }
}
