package com.example.sports_event_calendar.Services;

import com.example.sports_event_calendar.Models.DTOs.SportTypeDTO;
import com.example.sports_event_calendar.Repositories.SportTypeRepository;
import com.example.sports_event_calendar.Services.Mappers.SportTypeMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SportTypeService {
    public final SportTypeRepository sportTypeRepository;
    public final SportTypeMapper sportTypeMapper;

    public SportTypeService(SportTypeRepository sportTypeRepository,
                            SportTypeMapper sportTypeMapper) {
        this.sportTypeRepository = sportTypeRepository;
        this.sportTypeMapper = sportTypeMapper;
    }

    public List<SportTypeDTO> getAllSportTypes() {
        return sportTypeRepository.findAll()
                .stream()
                .map(sportTypeMapper::toSportTypeDTO)
                .toList();
    }
}
