package pl.matt.smartTravelling.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceService {

    List<PlaceEntity> getPlaces();

    Optional<PlaceEntity> get(Long id);

    void add(PlaceEntity placeEntity);

    void delete(Long id);

    void update(PlaceEntity placeEntity);

    List<PlaceEntity> getTripPlaces(Long id);
}
