package pl.matt.smartTravelling.Trip;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

@SpringBootApplication
public interface TripRepository extends JpaRepository<TripEntity, Long> {

    List<TripEntity> findAllByUserId(Long userId);


}