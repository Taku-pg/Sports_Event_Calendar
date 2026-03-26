package com.example.sports_event_calendar.Services;

import com.example.sports_event_calendar.Repositories.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamService {
    public final TeamRepository teamRepository;

    public TeamService(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<String> getTeamNames(String sportType){
        return teamRepository.findTeamNameBySportType(sportType);
    }
}
