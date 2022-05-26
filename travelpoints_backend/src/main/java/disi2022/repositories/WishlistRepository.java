package disi2022.repositories;

import disi2022.entities.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface WishlistRepository extends JpaRepository<Wishlist, Integer> {
    @Modifying
    @Query(value = "delete " +
            "FROM Wishlist w " +
            "WHERE w.attraction.id = :attractionId " +
            "AND w.user.id = :userId  ")
    void deleteWishlistByAttractionAndUser(@Param("attractionId") int attractionId, @Param("userId") int userId );


}
