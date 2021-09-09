package pl.matt.smartTravelling.Trip;


import java.util.List;
import java.util.Optional;

public interface TripService {

    List<Trip> getTrips();

    Optional<Trip> get(Long id);

    void add(Trip trip);

    void delete(Long id);

    void update(Trip trip);

}
