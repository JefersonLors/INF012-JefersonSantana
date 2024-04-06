package com.library.services;

import com.library.dtos.BookDto;
import com.library.models.Book;
import com.library.repositories.BookRepositoryInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService implements BookServiceInterface {
    @Autowired
    private BookRepositoryInterface bookRepository;

    @Override
    public BookDto getBookById(Long bookId) {
        Optional<Book> book = bookRepository.findById(bookId);
        return book.map(BookDto::new).orElse(null);
    }

    @Override
    public List<BookDto> getAllBooks() {
        List<Book> bookList = bookRepository.findAll();
        return bookList.stream().map(BookDto::new).collect(Collectors.toList());
    }

    @Override
    public BookDto createBook(BookDto bookDto) {
        Book book = bookRepository.save(new Book(bookDto));
        return new BookDto(book);
    }

    @Override
    public BookDto updateBook(BookDto bookDto, Long bookId) {
        if( bookRepository.existsById(bookId)){
            Book bookEntity = new Book(bookDto);
            bookEntity.setId(bookId);
            bookRepository.save(bookEntity);
            return bookDto;
        }
        return null;
    }

    @Override
    public void deleteBook(Long bookId) {
        if( bookRepository.existsById(bookId)){
            bookRepository.deleteById(bookId);
        }
    }
}
