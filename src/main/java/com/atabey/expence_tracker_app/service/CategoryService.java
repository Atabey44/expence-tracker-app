package com.atabey.expence_tracker_app.service;

import com.atabey.expence_tracker_app.dto.CategoryDto;
import com.atabey.expence_tracker_app.dto.CategoryDtoConverter;
import com.atabey.expence_tracker_app.dto.CreateCategoryDto;
import com.atabey.expence_tracker_app.dto.UpdateCategoryDto;
import com.atabey.expence_tracker_app.exception.ResourceNotFoundException;
import com.atabey.expence_tracker_app.model.Category;
import com.atabey.expence_tracker_app.repository.CategoryRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final CategoryDtoConverter categoryDtoConverter;

    public List<CategoryDto> getAllCategory() {

        return categoryRepository.findAll()
                .stream()
                .map(categoryDtoConverter::convert)
                .toList();
    }

    public CategoryDto getByIdCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category not found with id"+ id));
        return categoryDtoConverter.convert(category);
    }

    public CategoryDto createCategory(CreateCategoryDto createCategoryDto) {
        Category category = new Category();
        category.setName(createCategoryDto.getName());
        return categoryDtoConverter.convert(categoryRepository.save(category));
    }

    public CategoryDto updateCategory(
            Long id, UpdateCategoryDto updateCategoryDto) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category not found with id"+ id));

        category.setName(updateCategoryDto.getName());
        return categoryDtoConverter.convert(categoryRepository.save(category));

    }

    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Category not found with id"+ id));
        categoryRepository.delete(category);

    }
}
