package com.library.services;

import com.library.dtos.BookDto;
import com.library.models.Book;
import com.library.repositories.BookRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements BookServiceInterface {
    @Autowired
    private BookRepositoryInterface bookRepository;

    @Override
    public ResponseEntity<BookDto> getBookById(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return book.map(value -> new ResponseEntity<>(new BookDto(value), HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @Override
    public ResponseEntity<Page<BookDto>> getAllBooks(int page, int pageSize) {
        Pageable contentPageSize = PageRequest.of(page, pageSize);

        Page<BookDto> bookDtoPage = bookRepository.findAll(contentPageSize).map(BookDto::new);

        return ResponseEntity.ok(bookDtoPage);
    }

    @Override
    public ResponseEntity<BookDto> createBook(BookDto bookDto) {
        Book book = bookRepository.save(new Book(bookDto));
        return new ResponseEntity<>(new BookDto(book), HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<BookDto> updateBook(BookDto bookDto, Long bookId) {
        if( bookRepository.existsById(bookId)){
            Book bookEntity = new Book(bookDto);
            bookEntity.setId(bookId);
            Book updatedBook = bookRepository.save(bookEntity);
            return ResponseEntity.ok(new BookDto(updatedBook));
        }
        return ResponseEntity.notFound().build();
    }

    @Override
    public ResponseEntity<BookDto> deleteBook(Long bookId) {
        if( bookRepository.existsById(bookId)){
            bookRepository.deleteById(bookId);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}
