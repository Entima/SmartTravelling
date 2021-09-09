package pl.matt.smartTravelling.Trip;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public interface TripRepository extends JpaRepository<Trip, Long> {


}