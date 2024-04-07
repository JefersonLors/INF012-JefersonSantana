package com.library.services;

import com.library.dtos.GenderDto;
import com.library.models.Gender;
import com.library.repositories.GenderRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService implements GenderServiceInterface{
    @Autowired
    private GenderRepositoryInterface genderRepository;

    public ResponseEntity<GenderDto> getGenderById( Long genderId ){
        Optional<Gender> gender = genderRepository.findById(genderId);
        GenderDto genderDto = gender.map(GenderDto::new).orElse(null);

        if( genderDto != null )
            return ResponseEntity.ok(genderDto);
        return new ResponseEntity<GenderDto>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<List<GenderDto>> getAllGenders() {
        List<GenderDto> genderDtoList = genderRepository.findAll().stream()
                                                                  .map(GenderDto::new)
                                                                  .toList();
        return new ResponseEntity<List<GenderDto>>(genderDtoList, HttpStatus.OK);
    }

    public ResponseEntity<GenderDto> createGender(GenderDto genderDto ){
        Gender gender = genderRepository.save(new Gender(genderDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(new GenderDto(gender));
    }

    public ResponseEntity<GenderDto> updateGender(GenderDto genderDto, Long id) {
        if(genderRepository.existsById(id)){
            Gender gender = genderRepository.save(new Gender(genderDto));
            return new ResponseEntity<GenderDto>(new GenderDto(gender), HttpStatus.OK);
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<GenderDto> deleteGender(Long genderId) {
        if( genderRepository.existsById(genderId)){
            genderRepository.deleteById(genderId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }

}
