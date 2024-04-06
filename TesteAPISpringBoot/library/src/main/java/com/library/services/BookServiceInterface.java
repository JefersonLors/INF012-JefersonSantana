package com.library.services;

import com.library.dtos.BookDto;
import com.library.models.Book;

import java.util.List;

public interface BookServiceInterface {
    BookDto getBookById(Long bookId);
    List<BookDto> getAllBooks();
    BookDto createBook(BookDto bookDto);
    BookDto updateBook(BookDto bookDto, Long bookId);
    void deleteBook(Long bookId);

}
