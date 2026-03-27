package com.example.sports_event_calendar.Models.DTOs;

import com.example.sports_event_calendar.Models.Entities.Team;

import java.util.List;

public class SportTypeDTO {
    private  Long id;
    private  String sportTypeName;
    private  List<TeamDTO> allTeams;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSportTypeName() {
        return sportTypeName;
    }

    public void setSportTypeName(String sportTypeName) {
        this.sportTypeName = sportTypeName;
    }

    public List<TeamDTO> getAllTeams() {
        return allTeams;
    }

    public void setAllTeams(List<TeamDTO> allTeams) {
        this.allTeams = allTeams;
    }
}
