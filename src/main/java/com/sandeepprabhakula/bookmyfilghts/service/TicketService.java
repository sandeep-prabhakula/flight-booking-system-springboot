package com.sandeepprabhakula.bookmyfilghts.service;

import com.sandeepprabhakula.bookmyfilghts.data.Ticket;
import com.sandeepprabhakula.bookmyfilghts.repository.TicketRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class TicketService {
    private final TicketRepository ticketRepository;

    public List<Ticket> getTicketsByUID(String uid){
        return ticketRepository.findAllByUid(uid).get();
    }

    public String bookTicket(Ticket ticket){
        String uid = UUID.randomUUID().toString();
        ticket.setTicketId(uid);
        ticketRepository.save(ticket);
        return "Ticket Generated Successfully";
    }

    public void deleteTicket(String tid){
        ticketRepository.deleteById(tid);
    }
}
