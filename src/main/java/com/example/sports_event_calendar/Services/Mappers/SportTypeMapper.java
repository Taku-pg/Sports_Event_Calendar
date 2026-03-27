package com.example.sports_event_calendar.Services.Mappers;

import com.example.sports_event_calendar.Models.DTOs.SportTypeDTO;
import com.example.sports_event_calendar.Models.DTOs.TeamDTO;
import com.example.sports_event_calendar.Models.Entities.SportType;
import com.example.sports_event_calendar.Repositories.TeamRepository;
import com.example.sports_event_calendar.Services.TeamService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportTypeMapper {


    private final TeamService teamService;

    public SportTypeMapper(TeamService teamService) {
        this.teamService = teamService;
    }

    public SportTypeDTO toSportTypeDTO(SportType sportType) {
        SportTypeDTO sportTypeDTO = new SportTypeDTO();
        sportTypeDTO.setId(sportType.getId());
        sportTypeDTO.setSportTypeName(sportType.getSportType());

        List<TeamDTO> teamDTOS = teamService.getTeamDTOS(sportType);

        sportTypeDTO.setAllTeams(teamDTOS);

        return sportTypeDTO;
    }
}
