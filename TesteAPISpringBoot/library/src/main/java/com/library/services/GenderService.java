package com.library.services;

import com.library.dtos.GenderDto;
import com.library.models.Gender;
import com.library.repositories.GenderRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
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
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Page<GenderDto>> getAllGenders(int page, int pageSize) {
        Pageable contentPage = PageRequest.of(page, pageSize);

        Page<GenderDto> genderDtoList = genderRepository.findAll(contentPage).map(GenderDto::new);

        return new ResponseEntity<>( genderDtoList, HttpStatus.OK);
    }

    public ResponseEntity<GenderDto> createGender(GenderDto genderDto ){
        Gender gender = genderRepository.save(new Gender(genderDto));
        return ResponseEntity.status(HttpStatus.CREATED).body(new GenderDto(gender));
    }

    public ResponseEntity<GenderDto> updateGender(GenderDto genderDto, Long id) {
        if(genderRepository.existsById(id)){
            Gender gender = genderRepository.save(new Gender(genderDto));
            return new ResponseEntity<>(new GenderDto(gender), HttpStatus.OK);
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
