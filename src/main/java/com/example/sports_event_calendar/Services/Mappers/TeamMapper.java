package com.example.sports_event_calendar.Services.Mappers;

import com.example.sports_event_calendar.Models.DTOs.TeamDTO;
import com.example.sports_event_calendar.Models.Entities.Team;
import org.springframework.stereotype.Service;

@Service
public class TeamMapper {

    public TeamDTO toTeamDTO(Team team) {
        TeamDTO teamDTO = new TeamDTO();
        teamDTO.setId(team.getId());
        teamDTO.setTeamName(team.getTeamName());
        return teamDTO;
    }
}
