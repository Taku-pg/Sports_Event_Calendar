package com.example.sports_event_calendar.Services;

import com.example.sports_event_calendar.Models.DTOs.TeamDTO;
import com.example.sports_event_calendar.Models.Entities.SportType;
import com.example.sports_event_calendar.Models.Entities.Team;
import com.example.sports_event_calendar.Repositories.TeamRepository;
import com.example.sports_event_calendar.Services.Mappers.TeamMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final TeamMapper teamMapper;

    public TeamService(TeamRepository teamRepository,  TeamMapper teamMapper) {
        this.teamRepository = teamRepository;
        this.teamMapper = teamMapper;
    }

    public List<TeamDTO> getTeamDTOS(SportType sportType) {
        return teamRepository.findTeamBySportType(sportType)
                .stream()
                .map(teamMapper::toTeamDTO)
                .toList();
    }

    public Team findTeamById(Long id){
        return teamRepository.findTeamById(id).orElse(null);
    }
}
