package com.library.dtos;

import com.library.models.Gender;
import java.util.List;
import java.util.stream.Collectors;

public class GenderDto {
    private Long id;
    private String description;

    public GenderDto(Gender genderEntity){
        this.id = genderEntity.getId();
        this.description = genderEntity.getDescription();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static List<GenderDto> convert(List<Gender> genderList){
        return genderList.stream().map(GenderDto::new).collect(Collectors.toList());
    }
}
