package pl.matt.smartTravelling.Place;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface PlacesRepository extends JpaRepository<Place, Long> {


}
