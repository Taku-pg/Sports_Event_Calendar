package com.example.sports_event_calendar.Models.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity()
public class SportType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String sportType;
    @OneToMany(mappedBy = "sportType")
    private List<Team> teams;

    public SportType() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSportType() {
        return sportType;
    }

    public void setSportType(String sportType) {
        this.sportType = sportType;
    }

    public List<Team> getTeams() {
        return teams;
    }

    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }
}
