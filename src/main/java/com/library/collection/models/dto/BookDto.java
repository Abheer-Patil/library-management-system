package com.library.collection.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private String bookId;

    private String title;

    private String author;

    private String ISBN;

    private String genre;

    private String department;

    private Boolean available;

    private String publicationYear;

    private Boolean active;

    private LocalDateTime created;

    private LocalDateTime updated;
}
