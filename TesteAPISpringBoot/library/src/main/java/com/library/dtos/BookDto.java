package com.library.dtos;

import com.library.models.Book;
import com.library.models.Gender;

import java.util.List;
import java.util.stream.Collectors;

public record BookDto (Long id, String name, String synopsis, List<AuthorDto> authors, List<GenderDto> genders){
    public BookDto(Book bookEntity){
        this(bookEntity.getId(),
                bookEntity.getName(),
                bookEntity.getSynopsis(),
                AuthorDto.toAuthorDto(bookEntity.getAuthors()),
                GenderDto.toDtoList(bookEntity.getGenders()));
    }
    public static List<BookDto> toDtoList(List<Book> bookList){
        return bookList.stream().map(BookDto::new).collect(Collectors.toList());
    }
}
