package com.library.collection.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;


/**
 * Entity class representing a book in the library.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "BOOK_TABLE", uniqueConstraints = {@UniqueConstraint(columnNames = {"ISBN"})})
public class BookEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "BOOK_ID")
    private UUID bookId;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "AUTHOR")
    private String author;

    @Column(name = "ISBN")
    private String ISBN;

    @Column(name = "GENRE")
    private String genre;

    @Column(name = "DEPARTMENT")
    private String department;

    @Column(name = "AVAILABLE", columnDefinition = "boolean default true")
    private Boolean available;

    @Column(name = "ACTIVE", columnDefinition = "boolean default true")
    private Boolean active;

    @Column(name = "PUBLICATION_YEAR")
    private String publicationYear;

    @Column(name = "CREATED")
    @CreationTimestamp
    private LocalDateTime created;

    @Column(name = "UPDATED")
    @UpdateTimestamp
    private LocalDateTime updated;
}

