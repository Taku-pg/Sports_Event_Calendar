package com.example.sports_event_calendar.Repositories;

import com.example.sports_event_calendar.Models.Entities.SportType;
import com.example.sports_event_calendar.Models.Entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Integer> {
    Optional<Team> findTeamByTeamName(String teamName);

    List<Team> findTeamBySportType(SportType sportType);
    Optional<Team> findTeamById(Long id);
}
