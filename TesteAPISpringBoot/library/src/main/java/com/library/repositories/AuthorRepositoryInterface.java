package com.library.repositories;

import com.library.models.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepositoryInterface extends JpaRepository<Author, Long> {
}
