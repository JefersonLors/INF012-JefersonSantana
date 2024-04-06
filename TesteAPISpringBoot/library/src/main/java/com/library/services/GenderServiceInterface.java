package com.library.services;

import com.library.dtos.GenderDto;

import java.util.List;

public interface GenderServiceInterface {
     GenderDto createGender(GenderDto genderDto);
     GenderDto getGenderById(Long genderId);
     List<GenderDto> getAllGenders();
     GenderDto updateGender(GenderDto genderDto, Long id);
     void deleteGender(Long genderId);
}
