package com.sandeepprabhakula.bookmyfilghts.data;

import jakarta.persistence.*;
import lombok.*;

@Data
@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Ticket {
    @Id
    private String ticketId;
    private String uid;
    private String passengerName;
    private Integer passengerAge;
    private Gender gender;
    private TicketClass ticketClass;
    private double price;
    private String dateOfJourney;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="fk_flight_id")
    private RunningFlights bookedFlight;
}
