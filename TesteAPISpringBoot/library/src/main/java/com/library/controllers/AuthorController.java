package com.library.controllers;

import com.library.dtos.AuthorDto;
import com.library.services.AuthorServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {
    @Autowired
    private AuthorServiceInterface authorService;

    @GetMapping
    public List<AuthorDto> getAllAuthors(){
        return authorService.getAllAuthors();
    }

    @GetMapping("/authorId")
    public AuthorDto getAuthorById(@RequestParam Long authorId){
        return authorService.getAuthorById(authorId);
    }

    @PostMapping
    public AuthorDto createAuthor(@RequestBody AuthorDto authorDto){
        return authorService.createAuthor(authorDto);
    }

    @PutMapping("/{authorId}")
    public AuthorDto updateAuthor(@RequestBody AuthorDto authorDto,
                                  @PathVariable Long authorId){
        return authorService.updateAuthor(authorDto, authorId);
    }

    @DeleteMapping("/{authorId}")
    public void deleteAuthor(@PathVariable Long authorId){
        authorService.deleteAuthor(authorId);
    }
}
