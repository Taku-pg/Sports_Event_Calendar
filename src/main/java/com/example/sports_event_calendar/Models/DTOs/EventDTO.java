package com.example.sports_event_calendar.Models.DTOs;

import java.time.LocalDateTime;

public class EventDTO {
    private Long id;
    private String dayOfWeek;
    private LocalDateTime eventDate;
    private String sportType;
    private String firstTeamName;
    private String secondTeamName;
    private String venueName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public LocalDateTime getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDateTime eventDate) {
        this.eventDate = eventDate;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public String getFirstTeamName() {
        return firstTeamName;
    }

    public void setFirstTeamName(String firstTeamName) {
        this.firstTeamName = firstTeamName;
    }

    public String getSecondTeamName() {
        return secondTeamName;
    }

    public void setSecondTeamName(String secondTeamName) {
        this.secondTeamName = secondTeamName;
    }

    public String getVenueName() {
        return venueName;
    }

    public void setVenueName(String venue_name) {
        this.venueName = venue_name;
    }
}
