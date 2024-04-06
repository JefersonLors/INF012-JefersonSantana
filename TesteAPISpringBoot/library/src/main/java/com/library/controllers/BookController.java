package com.library.controllers;

import com.library.dtos.BookDto;
import com.library.models.Book;
import com.library.services.BookService;
import com.library.services.BookServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookServiceInterface bookService;
    @GetMapping
    public List<BookDto> getAllBooks(){
        return bookService.getAllBooks();
    }

    @GetMapping("/bookId")
    public BookDto getBookById(@RequestParam Long bookId){
        return bookService.getBookById(bookId);
    }

    @PostMapping
    public BookDto createBook(@RequestBody BookDto bookDto){
        return bookService.createBook(bookDto);
    }

    @PutMapping("/{bookId}")
    public BookDto updateBook(@RequestBody BookDto bookDto,
                              @PathVariable Long bookId){
        return bookService.updateBook(bookDto, bookId);
    }
    @DeleteMapping("/{bookId}")
    public void deleteBook(@PathVariable Long bookId){
        bookService.deleteBook(bookId);
    }

}
