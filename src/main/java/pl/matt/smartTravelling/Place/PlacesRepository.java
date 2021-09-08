package pl.matt.smartTravelling.Place;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.matt.smartTravelling.Trip.Trip;

public interface PlacesRepository extends JpaRepository<Place, Long> {


}
