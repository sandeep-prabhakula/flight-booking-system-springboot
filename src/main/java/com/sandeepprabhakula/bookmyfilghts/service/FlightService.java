package com.sandeepprabhakula.bookmyfilghts.service;

import com.sandeepprabhakula.bookmyfilghts.data.RunningFlights;
import com.sandeepprabhakula.bookmyfilghts.dto.FlightDTO;
import com.sandeepprabhakula.bookmyfilghts.repository.FlightsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class FlightService {
    private final FlightsRepository flightsRepository;
    public List<RunningFlights> getFlights(FlightDTO flightDTO){
        List<RunningFlights>flights = new ArrayList<>();
        for(RunningFlights flight: flightsRepository.findAll()){
            if(flight.getSrc().equals(flightDTO.getSrc()) &&
            flight.getDest().equals(flightDTO.getDest()) &&
            flight.getDeparture().substring(0,10).equals(flightDTO.getDate())) {
                flights.add(flight);
            }
        }
        return flights;
    }

    public void addFlights(RunningFlights newFlight){
        String fid = UUID.randomUUID().toString();
        newFlight.setId(fid);
        flightsRepository.save(newFlight);
    }
}
