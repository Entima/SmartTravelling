package pl.matt.smartTravelling.Trip;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.matt.smartTravelling.Trip.Trip;


public interface TripRepository extends JpaRepository<Trip, Long> {


}