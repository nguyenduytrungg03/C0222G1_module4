package com.backend.repository;

import com.backend.model.Ticket;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ITicketRepo extends JpaRepository<Ticket,Integer> {
    @Query(value = "select * from ticket", nativeQuery = true)
    Page<Ticket> findAllTicket(Pageable p);
//
//    @Query(value = "select * from ticket where start_play like :startPlay ",
//            nativeQuery = true)
    Page<Ticket> findAllByStartPlayContaining(@Param("startPlay") String startPlay, Pageable p);

}
