package pl.matt.smartTravelling.Trip;


import java.util.List;
import java.util.Optional;

public interface TripService {

    List<TripEntity> getTrips();

    Optional<TripEntity> get(Long id);

    void add(TripEntity tripEntity);

    void delete(Long id);

    void update(TripEntity tripEntity);

}
