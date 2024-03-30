package com.library.controllers;

import com.library.dtos.GenderDto;
import com.library.services.GenderServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/gender")
public class GenderController {
    @Autowired
    private GenderServiceInterface genderService;

    @PostMapping
    public void createGender(@RequestBody GenderDto genderDto){
        genderService.createGender(genderDto);
    }
    @GetMapping("/genderId")
    public GenderDto getGenderById(@RequestParam Long genderId){
        return genderService.getGenderById(genderId);
    }
    @GetMapping
    public List<GenderDto> getAllGenders(){
        return genderService.getAllGenders();
    }
    @PutMapping("/{genderId}")
    public GenderDto updateGender(@RequestBody GenderDto genderDto,
                                  @PathVariable Long genderId){
        return genderService.updateGender(genderDto, genderId);
    }
    @DeleteMapping("/{genderId}")
    public void deleteGender(@PathVariable Long genderId){
        genderService.deleteGender(genderId);
    }
}
