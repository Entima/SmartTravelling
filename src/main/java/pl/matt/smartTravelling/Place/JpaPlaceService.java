package pl.matt.smartTravelling.Place;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaPlaceService implements PlaceService {

    private final PlacesRepository placesRepository;

    public JpaPlaceService(PlacesRepository placesRepository) {
        this.placesRepository = placesRepository;
    }

    @Override
    public List<PlaceEntity> getPlaces() {
        return placesRepository.findAll();
    }

    @Override
    public Optional<PlaceEntity> get(Long id) {
        return placesRepository.findById(id);
    }

    @Override
    public void add(PlaceEntity placeEntity) {
        placesRepository.save(placeEntity);
    }

    @Override
    public void delete(Long id) {
        placesRepository.deleteById(id);
    }

    @Override
    public void update(PlaceEntity placeEntity) {
        placesRepository.save(placeEntity);
    }

    @Override
    public List<PlaceEntity> getTripPlaces(Long id) {
        return placesRepository.findAllByTripId(id);
    }


}
