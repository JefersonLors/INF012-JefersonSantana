package com.library.services;

import com.library.dtos.AuthorDto;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface AuthorServiceInterface {
    ResponseEntity<AuthorDto> getAuthorById(Long authorId);
    ResponseEntity<Page<AuthorDto>> getAllAuthors(int page, int pageSize);
    ResponseEntity<AuthorDto> createAuthor(AuthorDto authorDto);
    ResponseEntity<AuthorDto> updateAuthor(AuthorDto authorDto, Long authorId);
    ResponseEntity<AuthorDto> deleteAuthor(Long authorId);
}
