package disi2022.repositories;

import disi2022.entities.Attraction;;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttractionRepository extends JpaRepository<Attraction, Integer> {
}
