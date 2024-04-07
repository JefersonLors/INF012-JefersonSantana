package com.library.services;

import com.library.dtos.AuthorDto;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorServiceInterface {
    ResponseEntity<AuthorDto> getAuthorById(Long authorId);
    ResponseEntity<List<AuthorDto>> getAllAuthors();
    ResponseEntity<AuthorDto> createAuthor(AuthorDto authorDto);
    ResponseEntity<AuthorDto> updateAuthor(AuthorDto authorDto, Long authorId);
    ResponseEntity<AuthorDto> deleteAuthor(Long authorId);
}
