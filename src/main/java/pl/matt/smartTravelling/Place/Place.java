package pl.matt.smartTravelling.Place;

import javax.persistence.*;

@Entity
@Table(name = "place")

public class Place {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String photo;
    private String description;

}

