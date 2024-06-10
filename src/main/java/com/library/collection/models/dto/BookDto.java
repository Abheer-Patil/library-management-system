package com.library.collection.models.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    private Boolean availability;

    private String publicationYear;

    private Boolean active;
}
