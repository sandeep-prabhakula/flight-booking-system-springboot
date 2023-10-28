package com.sandeepprabhakula.bookmyfilghts.repository;

import com.sandeepprabhakula.bookmyfilghts.data.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository
public interface TicketRepository extends JpaRepository<Ticket,String> {
    Optional<List<Ticket>> findAllByUid(String email);
}
