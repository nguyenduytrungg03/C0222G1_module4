package com.backend.service;

import com.backend.model.Garage;
import com.backend.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ITicketService {


    Page<Ticket> getAll(Pageable pageable);

    List<Garage> customerType();

    void save(Ticket ticket);

    Ticket findById(int id);

    Page<Ticket> searchByName(String startPlay, Pageable p);
}
