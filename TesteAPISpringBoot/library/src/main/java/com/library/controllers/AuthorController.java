package com.library.controllers;

import com.library.dtos.AuthorDto;
import com.library.services.AuthorServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorServiceInterface authorService;

    @GetMapping
    public ResponseEntity<List<AuthorDto>> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/authorId")
    public ResponseEntity<AuthorDto> getAuthorById(@RequestParam Long authorId){
        return authorService.getAuthorById(authorId);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        return authorService.createAuthor(authorDto);
    }

    @PutMapping("/{authorId}")
    @Transactional
    public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto authorDto,
                                  @PathVariable Long authorId){
        return authorService.updateAuthor(authorDto, authorId);
    }

    @DeleteMapping("/{authorId}")
    @Transactional
    public ResponseEntity<AuthorDto> deleteAuthor(@PathVariable Long authorId){
        return authorService.deleteAuthor(authorId);
    }
}
