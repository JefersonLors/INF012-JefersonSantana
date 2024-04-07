package com.library.controllers;

import com.library.dtos.AuthorDto;
import com.library.services.AuthorServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    private AuthorServiceInterface authorService;

    @GetMapping
    public ResponseEntity<Page<AuthorDto>> getAllAuthors( @RequestParam(defaultValue = "0") int page,
                                                          @RequestParam(defaultValue = "1000") int pageSize ){
        return authorService.getAllAuthors(page, pageSize);
    }

    @GetMapping("/id")
    public ResponseEntity<AuthorDto> getAuthorById( @RequestParam Long id){
        return authorService.getAuthorById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AuthorDto> createAuthor(@RequestBody AuthorDto authorDto){
        return authorService.createAuthor(authorDto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<AuthorDto> updateAuthor(@RequestBody AuthorDto authorDto,
                                                  @PathVariable Long id){
        return authorService.updateAuthor(authorDto, id);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<AuthorDto> deleteAuthor(@PathVariable Long id) {
        return authorService.deleteAuthor(id);
    }
}
