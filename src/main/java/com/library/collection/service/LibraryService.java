package com.library.collection.service;

import com.library.collection.models.dto.BookDto;
import com.library.collection.models.response.BaseResponse;

/**
 * Service interface for managing books in a library.
 */
public interface LibraryService {

    /**
     * Adds a new book to the library.
     *
     * @param bookDto The DTO containing information about the book to be added.
     * @return A {@link BaseResponse} indicating the success of the operation.
     */
    BaseResponse addBook(BookDto bookDto);

    /**
     * Removes a book from the library by its ISBN.
     *
     * @param ISBN The ISBN of the book to be removed.
     * @return A {@link BaseResponse} indicating the success of the operation.
     */
    BaseResponse removeBookByISBN(String ISBN);

    /**
     * Retrieves a book by its title.
     *
     * @param title The title of the book to retrieve.
     * @return A {@link BaseResponse} containing information about the retrieved book, if found.
     */
    BaseResponse getBookByTitle(String title);

    /**
     * Retrieves books by their author.
     *
     * @param author The author of the books to retrieve.
     * @return A {@link BaseResponse} containing information about the retrieved books, if any are found.
     */
    BaseResponse getBookByAuthor(String author);

    /**
     * Lists all books in the library.
     *
     * @return A {@link BaseResponse} containing information about all books in the library.
     */
    BaseResponse listAllBooks();

    /**
     * Lists all available books in the library.
     *
     * @return A {@link BaseResponse} containing information about all available books in the library.
     */
    BaseResponse listAvailableBooks();
}


