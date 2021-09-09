package pl.matt.smartTravelling.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceService {

    List<Place> getPlaces();

    Optional<Place> get(Long id);

    void add(Place place);

    void delete(Long id);

    void update(Place place);
}
