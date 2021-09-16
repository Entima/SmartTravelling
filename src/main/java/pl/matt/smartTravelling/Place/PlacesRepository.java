package pl.matt.smartTravelling.Place;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SpringBootApplication
public interface PlacesRepository extends JpaRepository<PlaceEntity, Long> {
    List<PlaceEntity> findAllByTripId(Long id);

}
