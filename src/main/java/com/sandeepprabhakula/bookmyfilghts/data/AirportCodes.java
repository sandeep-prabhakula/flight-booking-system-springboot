package com.sandeepprabhakula.bookmyfilghts.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Data
@Entity
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class AirportCodes {
    @Id
    private String iataCode;
    private String icaoCode;
    private String airportName;
    private String cityName;
}
