package com.atabey.expence_tracker_app.dto;

import com.atabey.expence_tracker_app.model.Category;
import org.springframework.stereotype.Component;

@Component
public class CategoryDtoConverter {

    public CategoryDto convert(Category category){
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.setName(category.getName());
        return categoryDto;

    }

}
