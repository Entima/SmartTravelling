package pl.matt.smartTravelling.Place;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;
import pl.matt.smartTravelling.Trip.Trip;
import pl.matt.smartTravelling.Trip.TripRepository;
import pl.matt.smartTravelling.Trip.TripService;

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
    public List<Place> getPlaces() {
        return placesRepository.findAll();
    }

    @Override
    public Optional<Place> get(Long id) {
        return placesRepository.findById(id);
    }

    @Override
    public void add(Place place) {
        placesRepository.save(place);
    }

    @Override
    public void delete(Long id) {
        placesRepository.deleteById(id);
    }

    @Override
    public void update(Place place) {
        placesRepository.save(place);
    }


}
