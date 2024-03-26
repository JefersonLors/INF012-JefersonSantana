package com.library.services;

import com.library.dtos.GenderDto;

public interface GenderServiceInterface {
     void createGender(GenderDto genderDto);
     GenderDto getGenderById(Long genderId);
}
