package com.library.services;

import com.library.dtos.BookDto;
import com.library.models.Book;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface BookServiceInterface {
    ResponseEntity<BookDto> getBookById(Long bookId);
    ResponseEntity<Page<BookDto>> getAllBooks(int page, int pageSize);
    ResponseEntity<BookDto> createBook(BookDto bookDto);
    ResponseEntity<BookDto> updateBook(BookDto bookDto, Long bookId);
    ResponseEntity<BookDto> deleteBook(Long bookId);

}
