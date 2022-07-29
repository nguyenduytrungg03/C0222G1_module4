package com.backend.service.impl;

import com.backend.model.Garage;
import com.backend.model.Ticket;
import com.backend.repository.ITicketRepo;
import com.backend.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService implements ITicketService {
    @Autowired
    private ITicketRepo iTicketRepo;


    @Override
    public Page<Ticket> getAll(Pageable pageable) {
        return iTicketRepo.findAllTicket(pageable);
    }

    @Override
    public List<Garage> customerType() {
        return null;
    }

    @Override
    public void save(Ticket ticket) {
       if (ticket.getAmount()>0){
           ticket.setAmount(ticket.getAmount()-1);
           iTicketRepo.save(ticket);
       }else {
            iTicketRepo.save(ticket);
       }
    }

    @Override
    public Ticket findById(int id) {
        return null;
    }

    @Override
    public Page<Ticket> searchByName(String startPlay, Pageable p) {
        return iTicketRepo.findAllByStartPlayContaining(startPlay, p);
    }
}
