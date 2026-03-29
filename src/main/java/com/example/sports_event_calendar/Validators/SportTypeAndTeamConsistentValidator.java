package com.example.sports_event_calendar.Validators;

import com.example.sports_event_calendar.Models.DTOs.NewEventDTO;
import com.example.sports_event_calendar.Models.DTOs.TeamDTO;
import com.example.sports_event_calendar.Models.Entities.SportType;
import com.example.sports_event_calendar.Models.Entities.Team;
import com.example.sports_event_calendar.Repositories.SportTypeRepository;
import com.example.sports_event_calendar.Repositories.TeamRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Optional;

public class SportTypeAndTeamConsistentValidator implements ConstraintValidator<ValidSportTypeAndTeam, NewEventDTO> {

    private final TeamRepository teamRepository;
    private final SportTypeRepository sportTypeRepository;

    public SportTypeAndTeamConsistentValidator(TeamRepository teamRepository,
                                               SportTypeRepository sportTypeRepository) {
        this.teamRepository = teamRepository;
        this.sportTypeRepository = sportTypeRepository;
    }

    @Override
    public void initialize(ValidSportTypeAndTeam constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(NewEventDTO newEventDTO, ConstraintValidatorContext constraintValidatorContext) {
        Optional<TeamDTO> firstTeam = teamRepository.findTeamDTOById(newEventDTO.getFirstTeamId());
        Optional<TeamDTO> secondTeam = teamRepository.findTeamDTOById(newEventDTO.getSecondTeamId());
        String sportType = sportTypeRepository.findSportTypeName(newEventDTO.getSportTypeId());

        if (firstTeam.isEmpty() || secondTeam.isEmpty() || sportType.isEmpty()) {
            return false;
        }

        if(firstTeam.get().getTeamName().equals(secondTeam.get().getTeamName())) {
            return false;
        }


        if(!firstTeam.get().getSportName().equals(secondTeam.get().getSportName()) ||
                !firstTeam.get().getSportName().equals(sportType)) {
            return false;
        }
        return true;
    }
}
