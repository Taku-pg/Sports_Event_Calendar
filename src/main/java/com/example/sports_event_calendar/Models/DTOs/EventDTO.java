package com.example.sports_event_calendar.Models.DTOs;


public class EventDTO {
    private Long id;
    private String eventName;
    private String sportType;
    private String firstTeamName;
    private String secondTeamName;

    public EventDTO(Long id,
                    String eventName,
                    String sportType,
                    String firstTeamName,
                    String secondTeamName) {
        this.id = id;
        this.eventName = eventName;
        this.sportType = sportType;
        this.firstTeamName = firstTeamName;
        this.secondTeamName = secondTeamName;
    }

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
}
