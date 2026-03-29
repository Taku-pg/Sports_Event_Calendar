package com.example.sports_event_calendar.Repositories;

import com.example.sports_event_calendar.Models.DTOs.TeamDTO;
import com.example.sports_event_calendar.Models.Entities.SportType;
import com.example.sports_event_calendar.Models.Entities.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {

    Optional<Team> findTeamById(Long id);

    @Query("""
           SELECT new com.example.sports_event_calendar.Models.DTOs.TeamDTO(
                      t.id,
                      t.teamName
                      )FROM Team t WHERE t.sportType.sportType = :sportTypeName
           """)
    List<TeamDTO> findTeamDTOSBySportTypeName(@Param("sportTypeName") String sportTypeName);

    @Query("""
           SELECT new com.example.sports_event_calendar.Models.DTOs.TeamDTO(
                      t.id,
                      t.teamName,
                      st.sportType
                      )FROM Team t JOIN t.sportType st WHERE t.id = :id
           """)
    Optional<TeamDTO> findTeamDTOById(@Param("id") Long id);
}
