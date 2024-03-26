package com.library.controllers;

import com.library.dtos.GenderDto;
import com.library.services.GenderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/gender")
public class GenderController {
    @Autowired
    private GenderServiceInterface genderService;

    @PostMapping
    public void createGender(@RequestBody GenderDto genderDto){
        genderService.createGender(genderDto);
    }
    @GetMapping
    public GenderDto getGenderById(@RequestParam Long genderId){
        return genderService.getGenderById(genderId);
    }
}
