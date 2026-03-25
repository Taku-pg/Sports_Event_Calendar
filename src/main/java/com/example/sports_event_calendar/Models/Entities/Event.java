package com.example.sports_event_calendar.Models.Entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate eventDate;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "_first_team_id")
    private Team firstTeam;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "_second_team_id")
    private Team secondTeam;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "_venue_id")
    private Venue venue;

    public Event() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public Team getFirstTeam() {
        return firstTeam;
    }

    public void setFirstTeam(Team firstTeam) {
        this.firstTeam = firstTeam;
    }

    public Team getSecondTeam() {
        return secondTeam;
    }

    public void setSecondTeam(Team secondTeam) {
        this.secondTeam = secondTeam;
    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }
}
