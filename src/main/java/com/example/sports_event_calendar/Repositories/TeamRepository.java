package com.example.sports_event_calendar.Repositories;

import com.example.sports_event_calendar.Models.Entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    Optional<Team> findTeamByTeamName(String teamName);

    @Query("SELECT t.teamName FROM Team t WHERE t.sportType.sportType = :sportType")
    List<String> findTeamNameBySportType(String sportType);
}
