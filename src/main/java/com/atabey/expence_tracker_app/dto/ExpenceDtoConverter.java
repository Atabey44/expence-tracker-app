package com.atabey.expence_tracker_app.dto;

import com.atabey.expence_tracker_app.model.Expence;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ExpenceDtoConverter {

    public ExpenceDto convert (Expence expence){
        ExpenceDto expenceDto = new ExpenceDto();
        expenceDto.setAmount(expence.getAmount());
        expenceDto.setExpenceDate(LocalDateTime.now());
        expenceDto.setCategoryDto(expenceDto.getCategoryDto());
        return expenceDto;
    }
}
