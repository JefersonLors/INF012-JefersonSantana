package com.library.dtos;

import com.library.models.Author;
import java.util.List;
import java.util.stream.Collectors;

public record AuthorDto (Long id, String name){
    public AuthorDto(Author authorEntity){
        this(authorEntity.getId(), authorEntity.getName());
    }
    public static List<AuthorDto> toDtoList(List<Author> authorList ){
        return authorList.stream().map(AuthorDto::new).collect(Collectors.toList());
    }

}
