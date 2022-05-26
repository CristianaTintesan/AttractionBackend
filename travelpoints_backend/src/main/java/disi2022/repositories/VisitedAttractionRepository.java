package disi2022.repositories;

import disi2022.entities.Attraction;;
import disi2022.entities.VisitedAttraction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface VisitedAttractionRepository extends JpaRepository<VisitedAttraction,Integer> {
}
