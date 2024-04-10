package com.library.controllers;

import com.library.dtos.BookDto;
import com.library.models.Book;
import com.library.services.BookService;
import com.library.services.BookServiceInterface;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    @Autowired
    private BookServiceInterface bookService;
    @GetMapping
    public ResponseEntity<Page<BookDto>> getAllBooks( @RequestParam(defaultValue = "0") int page,
                                                      @RequestParam(defaultValue = "1000") int pageSize){
        return bookService.getAllBooks(page, pageSize);
    }

    @GetMapping("/id")
    public ResponseEntity<BookDto> getBookById(@RequestParam Long id){
        return bookService.getBookById(id);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto, HttpServletRequest request){
        String token = request.getHeader("Authorization");

        System.out.println("\n\n\ntoken : " + token);
        return bookService.createBook(bookDto);
    }

    @PutMapping("/{id}")
    @Transactional
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto,
                              @PathVariable Long id){
        return bookService.updateBook(bookDto, id);
    }
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<BookDto> deleteBook(@PathVariable Long id){
        return bookService.deleteBook(id);
    }

}
