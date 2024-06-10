package com.library.collection.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BookDto {

    private Long bookId;

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
