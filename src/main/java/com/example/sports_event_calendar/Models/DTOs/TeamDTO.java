package com.example.sports_event_calendar.Models.DTOs;

public class TeamDTO {
    private Long id;
    private String teamName;
    private String sportName;

    public TeamDTO(Long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public TeamDTO(Long id, String teamName, String sportName) {
        this.id = id;
        this.teamName = teamName;
        this.sportName = sportName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getSportName() {
        return sportName;
    }

    public void setSportName(String sportName) {
        this.sportName = sportName;
    }
}
