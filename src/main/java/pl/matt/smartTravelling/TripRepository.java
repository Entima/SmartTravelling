package pl.matt.smartTravelling;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Book;

public interface TripRepository extends JpaRepository<Trip, Long> {


}