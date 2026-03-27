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
    @ValidSportType
    private Long sportTypeId;
    @ValidTeam
    private Long firstTeamId;
    @ValidTeam
    private Long secondTeamId;
    @ValidVenue
    private Long venueId;

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

    public Long getSportTypeId() {
        return sportTypeId;
    }

    public void setSportTypeId(Long sportTypeId) {
        this.sportTypeId = sportTypeId;
    }

    public Long getFirstTeamId() {
        return firstTeamId;
    }

    public void setFirstTeamId(Long firstTeamId) {
        this.firstTeamId = firstTeamId;
    }

    public Long getSecondTeamId() {
        return secondTeamId;
    }

    public void setSecondTeamId(Long secondTeamId) {
        this.secondTeamId = secondTeamId;
    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }
}
