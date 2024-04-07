package com.library.models;

import com.library.dtos.BookDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.stream.Collectors;

@Entity(name="books")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String synopsis;
    @ManyToMany
    private List<Author> authors;
    @ManyToMany
    private List<Gender> genders;

    public Book(BookDto bookDto){
        this.id = bookDto.id();
        this.authors = bookDto.authors().stream()
                                        .map(Author::new)
                                        .collect(Collectors.toList());

        this.genders = bookDto.genders().stream()
                                        .map(Gender::new)
                                        .collect(Collectors.toList());
        this.name = bookDto.name();
        this.synopsis = bookDto.synopsis();
    }
}
