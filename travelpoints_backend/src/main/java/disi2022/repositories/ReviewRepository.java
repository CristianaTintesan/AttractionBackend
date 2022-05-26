package disi2022.repositories;
import disi2022.entities.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer>{
    List<Review> findAllByAttractionId(Integer attractionId);

    @Query("SELECT AVG(R.rating) FROM Review AS R JOIN Attraction AS A ON R.attraction = A WHERE A.id = :attractionId")
    Integer findAverageRatingForAttractionId(Integer attractionId);
}
