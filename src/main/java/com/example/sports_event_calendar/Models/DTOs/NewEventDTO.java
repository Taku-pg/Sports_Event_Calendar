package com.example.sports_event_calendar.Models.DTOs;

import com.example.sports_event_calendar.Validators.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@ValidSportTypeAndTeam
public class NewEventDTO {
    @NotBlank
    @Size(min = 1, max = 50)
    private String eventName;
    @ValidEventDate
    private LocalDateTime eventDate;
    @NotBlank
    @ValidSportType
    private String sportType;
    @NotBlank
    @ValidTeam
    private String firstTeamName;
    @NotBlank
    @ValidTeam
    private String secondTeamName;
    @NotBlank
    @ValidVenue
    private String venueName;

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

    public void setVenueName(String venueName) {
        this.venueName = venueName;
    }
}
