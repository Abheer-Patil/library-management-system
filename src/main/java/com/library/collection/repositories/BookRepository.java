package com.library.collection.repositories;

import com.library.collection.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    /**
     * Finds a list of book entities by availability and active status.
     *
     * @param available Indicates whether the books are available.
     * @return A list of book entities that match the specified availability and active status.
     */
    List<BookEntity> findBookEntityListByAvailableAndActiveTrue(Boolean available);

    /**
     * Finds a book entity by its ID and active status.
     *
     * @param bookId The ID of the book entity to find.
     * @return The book entity with the specified ID and active status.
     */
    BookEntity findBookEntityByBookIdAndActiveTrue(UUID bookId);

    /**
     * Finds a book entity by its ISBN and active status.
     *
     * @param ISBN The ISBN of the book entity to find.
     * @return The book entity with the specified ISBN and active status.
     */
    BookEntity findBookEntityByISBNAndActiveTrue(String ISBN);

    /**
     * Finds a list of all active book entities.
     *
     * @return A list of all active book entities.
     */
    List<BookEntity> findBookEntityListByActiveTrue();

    /**
     * Finds a list of book entities by author, availability, and active status.
     *
     * @param author The author's name (case-insensitive).
     * @return A list of book entities that match the specified author, availability, and active status.
     */
    @Query("SELECT b FROM BookEntity b WHERE b.available = true AND b.active = true AND LOWER(b.author) LIKE CONCAT('%', LOWER(:author), '%')")
    List<BookEntity> findBookEntityListByAuthorAndAvailableTrue(@Param("author") String author);

    /**
     * Finds a list of book entities by title, availability, and active status.
     *
     * @param title The title of the book (case-insensitive).
     * @return A list of book entities that match the specified title, availability, and active status.
     */
    @Query("SELECT b FROM BookEntity b WHERE b.available = true AND b.active = true AND LOWER(b.title) LIKE CONCAT('%', LOWER(:title), '%')")
    List<BookEntity> findBookEntityListByTitleAndAvailableTrue(@Param("title") String title);
}
