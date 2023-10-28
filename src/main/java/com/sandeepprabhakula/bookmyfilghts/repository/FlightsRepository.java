package com.sandeepprabhakula.bookmyfilghts.repository;

import com.sandeepprabhakula.bookmyfilghts.data.RunningFlights;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends JpaRepository<RunningFlights,Integer> {

}
