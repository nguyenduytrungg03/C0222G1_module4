package com.backend.controller;

import com.backend.model.Garage;
import com.backend.model.Ticket;
import com.backend.service.IGarageService;
import com.backend.service.ITicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class TicketRestController {

    @Autowired
    private IGarageService iGarageService;

    @Autowired
    private ITicketService iTicketService;


    @GetMapping("/list-ticket")
    public ResponseEntity<?> allTicket(@RequestParam(name = "page", defaultValue = "0") int page,
                                       @RequestParam(name = "startPlay", defaultValue = "") Optional<String> startPlay) {
        String name1 = startPlay.orElse("");
        System.out.println("name" + name1);
        Page<Ticket> ticketList = iTicketService.searchByName(name1, PageRequest.of(page, 5));
        if (ticketList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(ticketList, HttpStatus.OK);
    }

    @GetMapping("/list-garage")
    public ResponseEntity<?> allGarage() {
        List<Garage> garageList = iGarageService.findAll();
        if (garageList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(garageList, HttpStatus.OK);
    }

    @PostMapping("/add-ticket")
    public ResponseEntity<?> createTicket(@RequestBody Ticket ticket) {
        iTicketService.save(ticket);
        return new ResponseEntity<>(ticket, HttpStatus.CREATED);
    }
    @PutMapping("ord-ticket")
    public ResponseEntity<?> ordTicket(@RequestBody Ticket ticket) {
        iTicketService.save(ticket);
        System.out.println(ticket.toString());
        return new ResponseEntity<>(ticket, HttpStatus.OK);
    }

}
