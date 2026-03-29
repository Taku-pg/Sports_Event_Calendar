package com.example.sports_event_calendar.Services;

import com.example.sports_event_calendar.Models.DTOs.TeamDTO;
import com.example.sports_event_calendar.Models.Entities.Team;
import com.example.sports_event_calendar.Repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<TeamDTO> getTeamDTOS(String sportTypeName) {
        return teamRepository.findTeamDTOSBySportTypeName(sportTypeName);
    }

    public Team findTeamById(Long id){
        return teamRepository.findTeamById(id).orElse(null);
    }
}
