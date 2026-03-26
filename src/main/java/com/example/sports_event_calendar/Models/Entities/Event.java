package com.example.sports_event_calendar.Models.Entities;

import jakarta.persistence.*;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.util.Locale;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String eventName;
    private LocalDateTime eventDate;
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

    public String getEventName() {
        return eventName;
    }

    public void setEventName(String eventName) {
        this.eventName = eventName;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
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

    /**
     * calculate day of week
     * */
    public String getDayOfWeek(){
        DayOfWeek dow = DayOfWeek.from(eventDate);
        return dow.getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
    }


    /**
     * get name of first team
     * */
    public String getFirstTeamName(){
        return firstTeam.getTeamName();
    }

    /**
     * get name of second team
     * */
    public String getSecondTeamName(){
        return secondTeam.getTeamName();
    }

    /**
     * get name of sport type
     * */
    public String getSportType(){
        return firstTeam.getSportTypeName();
    }

    /**
     * get name of venue name
     * */
    public String getVenueName(){
        return venue.getVenueName();
    }
}
