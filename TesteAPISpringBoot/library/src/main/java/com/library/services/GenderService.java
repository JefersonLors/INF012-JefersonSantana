package com.library.services;

import com.library.dtos.GenderDto;
import com.library.models.Gender;
import com.library.repositories.GenderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenderService implements GenderServiceInterface{
    @Autowired
    private GenderRepository genderRepository;

    public void createGender(GenderDto genderDto ){
        System.out.println(genderDto);
        var genderEP = DtoToEntityPersistence(genderDto, new Gender());
        genderRepository.save(genderEP);
    }

    private Gender DtoToEntityPersistence(GenderDto genderDto, Gender genderEntity ){
        genderEntity.setDescription(genderDto.getDescription());
        return genderEntity;
    }

    public GenderDto getGenderById( Long genderId ){
        List<Gender> genderList = genderRepository.findById(genderId).stream().toList();
        Optional<Gender> genderEP= genderList.stream().findFirst();
        return genderEP.map(GenderDto::new).orElse(null);
    }
}
