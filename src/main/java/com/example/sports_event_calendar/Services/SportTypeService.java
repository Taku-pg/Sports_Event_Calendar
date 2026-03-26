package com.example.sports_event_calendar.Services;

import com.example.sports_event_calendar.Models.Entities.SportType;
import com.example.sports_event_calendar.Repositories.SportTypeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportTypeService {
    public final SportTypeRepository sportTypeRepository;

    public SportTypeService(SportTypeRepository sportTypeRepository) {
        this.sportTypeRepository = sportTypeRepository;
    }

    public List<SportType> getAllSportTypes() {
        return sportTypeRepository.findAll();
    }
}
