package com.example.sports_event_calendar.Validators;

import com.example.sports_event_calendar.Models.DTOs.NewEventDTO;
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
        Optional<Team> firstTeam = teamRepository.findTeamById(newEventDTO.getFirstTeamId());
        Optional<Team> secondTeam = teamRepository.findTeamById(newEventDTO.getSecondTeamId());
        Optional<SportType> sportType = sportTypeRepository.findById(newEventDTO.getSportTypeId());

        if (firstTeam.isEmpty() || secondTeam.isEmpty() || sportType.isEmpty()) {
            return false;
        }

        if(firstTeam.get().getTeamName().equals(secondTeam.get().getTeamName())) {
            return false;
        }

        final String firstTeamSportType = firstTeam.get().getSportTypeName();
        final String secondTeamSportType = secondTeam.get().getSportTypeName();
        final String sportTypeName = sportType.get().getSportType();

        if(!firstTeamSportType.equals(secondTeamSportType) ||
                !firstTeamSportType.equals(sportTypeName)) {
            return false;
        }
        return true;
    }
}
