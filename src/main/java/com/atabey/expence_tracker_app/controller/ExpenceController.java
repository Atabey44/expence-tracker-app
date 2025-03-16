package com.atabey.expence_tracker_app.controller;

import com.atabey.expence_tracker_app.dto.CreateExpenceDto;
import com.atabey.expence_tracker_app.dto.ExpenceDto;
import com.atabey.expence_tracker_app.dto.UpdateExpenceDto;
import com.atabey.expence_tracker_app.model.Expence;
import com.atabey.expence_tracker_app.repository.ExpenceRepository;
import com.atabey.expence_tracker_app.service.ExpenceService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/expencies")
@RequiredArgsConstructor
public class ExpenceController {

    private final ExpenceService expenceService;

    @GetMapping("/getAllExpencies")
    public ResponseEntity<List<ExpenceDto>> getAllExpencies(){

        return ResponseEntity.ok(expenceService.getAllExpencies());
    };

   @PostMapping("/createExpence")
    public ResponseEntity<ExpenceDto> createExpence(
            @RequestBody CreateExpenceDto createExpenceDto){
       return ResponseEntity.ok(expenceService.createExpence(createExpenceDto));
   }

   @PutMapping("/updateExpence/{id}")
    public ResponseEntity<ExpenceDto> updateExpence(
            @RequestParam Long id, @RequestBody UpdateExpenceDto updateExpenceDto){
       return ResponseEntity.ok(expenceService.updateExpence(id, updateExpenceDto));

   }

   @GetMapping("/getByIdExpence/{id}")
    public ResponseEntity<ExpenceDto>  getByIdExpence(@PathVariable Long id){
       return ResponseEntity.ok(expenceService.getByIdExpence(id));
   }

   @DeleteMapping("/deleteExpence/{id}")
    public ResponseEntity<String> deleteExpence(@PathVariable Long id){
       expenceService.deleteExpenceById(id);
       return ResponseEntity.ok("Expence deleted successfully ");

   }

}
