package com.sandeepprabhakula.bookmyfilghts.contoller;

import com.sandeepprabhakula.bookmyfilghts.data.Ticket;
import com.sandeepprabhakula.bookmyfilghts.service.TicketService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TicketController {
    private final TicketService ticketService;

    @GetMapping("/get-my-bookings/{uid}")
    public List<Ticket> getMyTickets(@PathVariable("uid") String uid){
        return ticketService.getTicketsByUID(uid);
    }

    @PostMapping("/book-flight")
    public String bookMyTicket(@RequestBody Ticket ticket){
        return ticketService.bookTicket(ticket);
    }

    @DeleteMapping("/delete-ticket/{tid}")
    public ResponseEntity<String> deleteTicket(@PathVariable String tid){
        ticketService.deleteTicket(tid);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
