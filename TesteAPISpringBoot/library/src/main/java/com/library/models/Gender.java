package com.library.models;

import com.library.dtos.GenderDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.List;
import java.util.stream.Collectors;

@Entity(name="Genders")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String description;

    public Gender(GenderDto genderDto){
        this.id = genderDto.id();
        this.description = genderDto.description();
    }
    public Gender(){}
    public Long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<Gender> toEntityList(List<GenderDto> genderDtoList){
        return genderDtoList.stream().map(Gender::new).collect(Collectors.toList());
    }
}
