package pl.matt.smartTravelling;

import java.awt.print.Book;
import java.util.List;
import java.util.Optional;

public interface TripService {

    List<Trip> getTrips();

    Optional<Trip> get(Long id);

    void add(Trip trip);

    void delete(Long id);

    void update(Trip trip);

}
