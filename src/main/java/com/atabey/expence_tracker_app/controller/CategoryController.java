package com.atabey.expence_tracker_app.controller;


import com.atabey.expence_tracker_app.dto.CategoryDto;
import com.atabey.expence_tracker_app.dto.CreateCategoryDto;
import com.atabey.expence_tracker_app.dto.UpdateCategoryDto;
import com.atabey.expence_tracker_app.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;


    @GetMapping("/getAllCategory")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
        return ResponseEntity.ok(categoryService.getAllCategory());
    }

    @GetMapping("/getByIdCategory")
    public ResponseEntity<CategoryDto> getByIdCategory(@RequestParam Long id){
        return ResponseEntity.ok(categoryService.getByIdCategory(id));
    }

    @PostMapping("/createCategory")
    public ResponseEntity<CategoryDto> createCategory
            (@RequestBody CreateCategoryDto createCategoryDto){
        return new ResponseEntity<>
                (categoryService.createCategory(createCategoryDto),HttpStatus.CREATED);
    }

    @PutMapping("/updateCategory/{id}")
    public ResponseEntity<CategoryDto> updateCategory(
            @PathVariable Long id, @RequestBody UpdateCategoryDto updateCategoryDto){
        return ResponseEntity.ok(categoryService.updateCategory(id, updateCategoryDto));
    }

    @DeleteMapping("/deleteCategory/{id}")
    public String deleteCategory(@PathVariable Long id){
        categoryService.deleteCategory(id);
        return "Category deleted successfully";
    }



}
