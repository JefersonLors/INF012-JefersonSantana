package com.library.services;

import com.library.dtos.GenderDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface GenderServiceInterface {
     ResponseEntity<GenderDto> createGender(GenderDto genderDto);
     ResponseEntity<GenderDto> getGenderById(Long genderId);
     ResponseEntity<List<GenderDto>> getAllGenders();
     ResponseEntity<GenderDto> updateGender(GenderDto genderDto, Long id);
     ResponseEntity<GenderDto> deleteGender(Long genderId);
}
