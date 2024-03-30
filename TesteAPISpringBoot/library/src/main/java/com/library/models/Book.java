package com.library.models;

import com.library.dtos.BookDto;
import jakarta.persistence.*;
import java.util.List;

@Entity(name="books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String synopsis;
    @ManyToMany
    private List<Author> authors;
    @ManyToMany
    private List<Gender> genders;

    public Book(){}

    public Book(BookDto bookDto){
        this.id = bookDto.id();
        this.authors = Author.toEntityList(bookDto.authors());
        this.genders = Gender.toEntityList(bookDto.genders());
        this.name = bookDto.name();
        this.synopsis = bookDto.synopsis();
    }
    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Gender> getGenders() {
        return genders;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    public void setGenders(List<Gender> genders) {
        this.genders = genders;
    }
}
