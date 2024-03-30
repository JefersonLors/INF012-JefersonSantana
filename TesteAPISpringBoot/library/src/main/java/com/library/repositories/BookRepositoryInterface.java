package com.library.repositories;

import com.library.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepositoryInterface extends JpaRepository<Book, Long> {
}
