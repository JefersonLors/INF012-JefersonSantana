package com.library.dtos;

import com.library.models.Book;

import java.util.List;
import java.util.stream.Collectors;

public class BookDto {
    private Long id;
    private String name;
    private String synopsis;
    private List<AuthorDto> authors;
    private List<GenderDto> genders;

    public BookDto(Book bookEntity){
        this.id = bookEntity.getId();
        this.name = bookEntity.getName();
        this.authors = AuthorDto.convert(bookEntity.getAuthors());
        this.synopsis = bookEntity.getSynopsis();
        this.genders = GenderDto.convert(bookEntity.getGenders());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSynopsis() {
        return synopsis;
    }

    public void setSynopsis(String synopsis) {
        this.synopsis = synopsis;
    }

    public List<AuthorDto> getAuthors() {
        return authors;
    }

    public void setAuthors(List<AuthorDto> authors) {
        this.authors = authors;
    }

    public List<GenderDto> getGender() {
        return genders;
    }

    public void setGender(List<GenderDto> genders) {
        this.genders = genders;
    }

    public static List<BookDto> convert(List<Book> bookList){
        return bookList.stream().map(BookDto::new).collect(Collectors.toList());
    }
}
