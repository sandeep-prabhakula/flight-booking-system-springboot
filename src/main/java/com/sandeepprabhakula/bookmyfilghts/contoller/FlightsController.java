package com.sandeepprabhakula.bookmyfilghts.contoller;

import com.sandeepprabhakula.bookmyfilghts.data.RunningFlights;
import com.sandeepprabhakula.bookmyfilghts.data.Ticket;
import com.sandeepprabhakula.bookmyfilghts.dto.FlightDTO;
import com.sandeepprabhakula.bookmyfilghts.repository.FlightsRepository;
import com.sandeepprabhakula.bookmyfilghts.service.FlightService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FlightsController {

private final FlightService flightService;

    @GetMapping("/get-flights")
    public List<RunningFlights> getFlights(@RequestBody FlightDTO flightDTO){
        return flightService.getFlights(flightDTO);
    }

    @PostMapping("/add-flights")
    @PreAuthorize("hasAuthority('ROLE_ADMIN')")
    public ResponseEntity<String>addFlights(@RequestBody RunningFlights newFlight){
        flightService.addFlights(newFlight);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

}
