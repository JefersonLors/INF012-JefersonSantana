package com.library.dtos;

import com.library.models.Gender;
import java.util.List;
import java.util.stream.Collectors;

public record GenderDto( Long id, String description) {
    public GenderDto(Gender genderEntity){
        this(genderEntity.getId(), genderEntity.getDescription());
    }
    public static List<GenderDto> toDtoList(List<Gender> genderList){
        return genderList.stream().map(GenderDto::new).collect(Collectors.toList());
    }
}
