package com.library.dtos;

import com.library.models.Author;
import java.util.List;
import java.util.stream.Collectors;

public class AuthorDto {
    private Long id;
    private String name;

    public AuthorDto(Author authorEntity){
        this.id = authorEntity.getId();
        this.name = authorEntity.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public static List<AuthorDto> convert(List<Author> authorList ){
        return authorList.stream().map(AuthorDto::new).collect(Collectors.toList());
    }

}
