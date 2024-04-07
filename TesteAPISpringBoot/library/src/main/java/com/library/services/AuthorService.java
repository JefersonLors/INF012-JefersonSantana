package com.library.services;

import com.library.dtos.AuthorDto;
import com.library.models.Author;
import com.library.repositories.AuthorRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService implements AuthorServiceInterface{
    @Autowired
    private AuthorRepositoryInterface authorRepository;
    public ResponseEntity<AuthorDto> getAuthorById(Long authorId) {
        Optional<Author> author = authorRepository.findById(authorId);
        AuthorDto authorDto = author.map(AuthorDto::new).orElse(null);

        if( authorDto != null)
            return new ResponseEntity<AuthorDto>(authorDto, HttpStatus.OK);
        return new ResponseEntity<AuthorDto>(HttpStatus.NOT_FOUND);
    }

    public ResponseEntity<Page<AuthorDto>> getAllAuthors(int page, int pageSize){
        Pageable firstPage = PageRequest.of(page, pageSize);
        Page<AuthorDto> authorsDtoList = authorRepository.findAll(firstPage).map(AuthorDto::new);

        return ResponseEntity.ok().body(authorsDtoList);
    }

    public ResponseEntity<AuthorDto> createAuthor(AuthorDto authorDto) {
        Author authorEntity = authorRepository.save(new Author(authorDto));
        return ResponseEntity.status(HttpStatus.CREATED)
                             .body(new AuthorDto(authorEntity));
    }

    public ResponseEntity<AuthorDto> updateAuthor(AuthorDto authorDto, Long authorId) {
        if( authorRepository.existsById(authorId)){
            Author authorEntity = authorRepository.save(new Author(authorDto));
            return ResponseEntity.status(HttpStatus.OK)
                                 .body(new AuthorDto(authorEntity));
        }
        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity<AuthorDto> deleteAuthor(Long authorId) {
        if( authorRepository.existsById(authorId)){
            authorRepository.deleteById(authorId);
            return new ResponseEntity<AuthorDto>(HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }
}
