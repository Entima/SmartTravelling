package pl.matt.smartTravelling;

import javax.persistence.*;
import java.sql.Timestamp;


@Entity
@Table(name = "trips")

public class Trip {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private Timestamp startDate;
    private Timestamp endDate;
    private String description;

}
