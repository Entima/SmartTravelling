package pl.matt.smartTravelling.Trip;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Primary
public class JpaTripService implements TripService {

    private final TripRepository tripRepository;

    public JpaTripService(TripRepository tripRepository) {
        this.tripRepository = tripRepository;
    }

    @Override
    public List<Trip> getTrips() {
        return tripRepository.findAll();
    }

    @Override
    public Optional<Trip> get(Long id) {
        return tripRepository.findById(id);
    }

    @Override
    public void add(Trip trip) {
        tripRepository.save(trip);
    }

    @Override
    public void delete(Long id) {
        tripRepository.deleteById(id);
    }

    @Override
    public void update(Trip trip) {
        tripRepository.save(trip);
    }


}
