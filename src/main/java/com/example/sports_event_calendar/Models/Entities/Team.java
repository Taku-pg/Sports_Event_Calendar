package com.example.sports_event_calendar.Models.Entities;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String teamName;
    @ManyToOne
    @JoinColumn(name = "_sport_type_id")
    private SportType sportType;
    @OneToMany(mappedBy = "firstTeam")
    private List<Event> eventsJoinAsFirstTeam;
    @OneToMany(mappedBy = "secondTeam")
    private List<Event> eventsJoinAsSecondTeam;

    public Team() {}

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

    public SportType getSportType() {
        return sportType;
    }

    public void setSportType(SportType sportType) {
        this.sportType = sportType;
    }

    public List<Event> getEventsJoinAsFirstTeam() {
        return eventsJoinAsFirstTeam;
    }

    public void setEventsJoinAsFirstTeam(List<Event> eventsJoinAsFirstTeam) {
        this.eventsJoinAsFirstTeam = eventsJoinAsFirstTeam;
    }

    public List<Event> getEventsJoinAsSecondTeam() {
        return eventsJoinAsSecondTeam;
    }

    public void setEventsJoinAsSecondTeam(List<Event> eventsJoinAsSecondTeam) {
        this.eventsJoinAsSecondTeam = eventsJoinAsSecondTeam;
    }

    /**
     * get sport type name
     * */
    public String getSportTypeName() {
        return sportType.getSportType();
    }
}
