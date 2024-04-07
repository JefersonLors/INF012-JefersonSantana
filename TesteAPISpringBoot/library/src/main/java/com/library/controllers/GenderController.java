package com.library.controllers;

import com.library.dtos.GenderDto;
import com.library.services.GenderServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gender")
public class GenderController {
    @Autowired
    private GenderServiceInterface genderService;

    @GetMapping("/genderId")
    public ResponseEntity<GenderDto> getGenderById(@RequestParam Long genderId){
        return genderService.getGenderById(genderId);
    }
    @GetMapping
    public ResponseEntity<List<GenderDto>> getAllGenders(){
        return genderService.getAllGenders();
    }
    @PostMapping
    @Transactional
    public ResponseEntity<GenderDto> createGender(@RequestBody GenderDto genderDto){
        return genderService.createGender(genderDto);
    }
    @PutMapping("/{genderId}")
    @Transactional
    public ResponseEntity<GenderDto> updateGender(@RequestBody GenderDto genderDto,
                                  @PathVariable Long genderId){
        return genderService.updateGender(genderDto, genderId);
    }
    @DeleteMapping("/{genderId}")
    @Transactional
    public ResponseEntity<GenderDto> deleteGender(@PathVariable Long genderId){
        return genderService.deleteGender(genderId);
    }
}
