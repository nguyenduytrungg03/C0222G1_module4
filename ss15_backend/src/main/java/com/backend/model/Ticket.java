package com.backend.model;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity(name = "ticket")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "start_play")
    private String startPlay;
    @Column(name = "end_play")
    private String endPlay;
    @Column(name = "count_ticket")
    private String countTicket;
    private String dayPlay;
    private String timePlay;
    private Integer amount;
    @ManyToOne()
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name="garage_id", nullable=false)
    private Garage garage;

    public Garage getGarage() {
        return garage;
    }

    public void setGarage(Garage garage) {
        this.garage = garage;
    }

    public Ticket() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStartPlay() {
        return startPlay;
    }

    public void setStartPlay(String startPlay) {
        this.startPlay = startPlay;
    }

    public String getEndPlay() {
        return endPlay;
    }

    public void setEndPlay(String endPlay) {
        this.endPlay = endPlay;
    }

    public String getCountTicket() {
        return countTicket;
    }

    public void setCountTicket(String countTicket) {
        this.countTicket = countTicket;
    }

    public String getDayPlay() {
        return dayPlay;
    }

    public void setDayPlay(String dayPlay) {
        this.dayPlay = dayPlay;
    }

    public String getTimePlay() {
        return timePlay;
    }

    public void setTimePlay(String timePlay) {
        this.timePlay = timePlay;
    }


    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
// id?: number,
//  startPlay?: string,
//  endPlay?: string,
//  countTicket?: string,
//  dayPlay?: string,
//  timePlay?: string,
//  garage: Garage,
//  amount?: string,