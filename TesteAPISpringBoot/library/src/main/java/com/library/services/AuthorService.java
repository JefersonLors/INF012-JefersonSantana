package com.library.services;

import com.library.dtos.AuthorDto;
import com.library.models.Author;
import com.library.repositories.AuthorRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorService implements AuthorServiceInterface{
    @Autowired
    private AuthorRepositoryInterface authorRepository;
    public AuthorDto getAuthorById(Long authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        return author.map(AuthorDto::new).orElse(null);
    }

    public List<AuthorDto> getAllAuthors() {
        List<Author> authors = authorRepository.findAll();
        return AuthorDto.toAuthorDto(authors);
    }

    public AuthorDto createAuthor(AuthorDto authorDto) {
        Author authorEntity = authorRepository.save(new Author(authorDto));
        return new AuthorDto(authorEntity);
    }

    public AuthorDto updateAuthor(AuthorDto authorDto, Long authorId) {
        if( authorRepository.existsById(authorId)){
            Author authorEntity = authorRepository.save(new Author(authorDto));
            return new AuthorDto(authorEntity);
        }
        return null;
    }

    public void deleteAuthor(Long authorId) {
        if( authorRepository.existsById(authorId)){
            authorRepository.deleteById(authorId);
        }
    }
}
