package com.atabey.expence_tracker_app.dto;

import com.atabey.expence_tracker_app.model.Category;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ExpenceDto {

    private double amount;
    private LocalDateTime expenceDate;
    private CategoryDto categoryDto;

}

