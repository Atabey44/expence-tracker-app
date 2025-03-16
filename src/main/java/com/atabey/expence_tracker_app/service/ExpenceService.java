package com.atabey.expence_tracker_app.service;

import com.atabey.expence_tracker_app.dto.CreateExpenceDto;
import com.atabey.expence_tracker_app.dto.ExpenceDto;
import com.atabey.expence_tracker_app.dto.ExpenceDtoConverter;
import com.atabey.expence_tracker_app.dto.UpdateExpenceDto;
import com.atabey.expence_tracker_app.exception.ResourceNotFoundException;
import com.atabey.expence_tracker_app.model.Expence;
import com.atabey.expence_tracker_app.repository.ExpenceRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ExpenceService {

    private final ExpenceRepository expenceRepository;
    private final ExpenceDtoConverter expenceDtoConverter;


    public List<ExpenceDto> getAllExpencies() {
        return expenceRepository.findAll()
                .stream()
                .map(expenceDtoConverter::convert)
                .toList();
    }

    public ExpenceDto createExpence(CreateExpenceDto createExpenceDto) {
        Expence expence =  new Expence();
        expence.setAmount(createExpenceDto.getAmount());
        expence.setExpenceDate(LocalDateTime.now());
        return expenceDtoConverter.convert(expenceRepository.save(expence));
    }


    public ExpenceDto updateExpence(Long id, UpdateExpenceDto updateExpenceDto) {
        Expence expence = expenceRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Expence not found with id "+ id));

        expence.setExpenceDate(LocalDateTime.now());
        expence.setAmount(updateExpenceDto.getAmount());

        return expenceDtoConverter.convert(expenceRepository.save(expence));
    }

    public ExpenceDto getByIdExpence (Long id){
        Expence expence = expenceRepository.findById(id)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Expence not found with id " + id));

        return expenceDtoConverter.convert(expence);
    }

    public void deleteExpenceById(Long id){
        Expence expence = expenceRepository.findById(id)
                .orElseThrow(
                        ()-> new ResourceNotFoundException("Expence not found with id " + id));
        expenceRepository.delete(expence);
    }



}
