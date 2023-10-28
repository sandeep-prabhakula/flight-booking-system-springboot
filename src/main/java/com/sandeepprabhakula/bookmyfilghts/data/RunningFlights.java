package com.sandeepprabhakula.bookmyfilghts.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RunningFlights {
    @Id
    private String id;
    private String airline;
    private String flightNumber;
    private String src;
    private String dest;
    private String departure;
    private String arrival;
    private String duration;
    private String price;
}
