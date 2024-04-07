package com.library.controllers;

import com.library.dtos.GenderDto;
import com.library.services.GenderServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/genders")
public class GenderController {
    @Autowired
    private GenderServiceInterface genderService;

    @GetMapping("/id")
    public ResponseEntity<GenderDto> getGenderById(@RequestParam Long id){
        return genderService.getGenderById(id);
    }
    @GetMapping
    public ResponseEntity<Page<GenderDto>> getAllGenders(@RequestParam(defaultValue = "0") int page,
                                                         @RequestParam(defaultValue = "1000") int pageSize){
        return genderService.getAllGenders(page, pageSize);
    }
    @PostMapping
    @Transactional
    public ResponseEntity<GenderDto> createGender(@RequestBody GenderDto genderDto){
        return genderService.createGender(genderDto);
    }
    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<GenderDto> updateGender(@RequestBody GenderDto genderDto,
                                                    @PathVariable Long id){
        return genderService.updateGender(genderDto, id);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<GenderDto> deleteGender(@PathVariable Long id){
        return genderService.deleteGender(id);
    }
}
