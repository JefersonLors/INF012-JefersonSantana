package com.library.models;

import com.library.dtos.AuthorDto;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity(name="Authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    public Author(AuthorDto authorDto){
        this.id = authorDto.id();
        this.name = authorDto.name();
    }
    public Author(){}
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}
