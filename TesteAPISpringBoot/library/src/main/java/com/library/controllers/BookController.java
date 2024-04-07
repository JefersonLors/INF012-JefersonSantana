package com.library.controllers;

import com.library.dtos.BookDto;
import com.library.models.Book;
import com.library.services.BookService;
import com.library.services.BookServiceInterface;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceInterface bookService;
    @GetMapping
    public ResponseEntity<List<BookDto>> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/bookId")
    public ResponseEntity<BookDto> getBookById(@RequestParam Long bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping
    @Transactional
    public ResponseEntity<BookDto> createBook(@RequestBody BookDto bookDto){
        return bookService.createBook(bookDto);
    }

    @PutMapping("/{bookId}")
    @Transactional
    public ResponseEntity<BookDto> updateBook(@RequestBody BookDto bookDto,
                              @PathVariable Long bookId){
        return bookService.updateBook(bookDto, bookId);
    }
    @DeleteMapping("/{bookId}")
    @Transactional
    public ResponseEntity<BookDto> deleteBook(@PathVariable Long bookId){
        return bookService.deleteBook(bookId);
    }

}
