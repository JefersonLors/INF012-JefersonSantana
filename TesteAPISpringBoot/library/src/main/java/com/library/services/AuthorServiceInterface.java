package com.library.services;

import com.library.dtos.AuthorDto;

import java.util.List;

public interface AuthorServiceInterface {
    AuthorDto getAuthorById(Long authorId);
    List<AuthorDto> getAllAuthors();
    AuthorDto createAuthor(AuthorDto authorDto);
    AuthorDto updateAuthor(AuthorDto authorDto, Long authorId);
    void deleteAuthor(Long authorId);
}
