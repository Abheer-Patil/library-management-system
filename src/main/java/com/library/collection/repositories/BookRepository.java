package com.library.collection.repositories;

import com.library.collection.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface BookRepository extends JpaRepository<BookEntity, UUID> {

    List<BookEntity> findBookEntityListByAvailableAndActiveTrue(Boolean available);

    BookEntity findBookEntityByBookIdAndActiveTrue(UUID bookId);
    BookEntity findBookEntityByISBNAndActiveTrue(String ISBN);

    List<BookEntity> findBookEntityListByActiveTrue();

    @Query("SELECT b FROM BookEntity b WHERE b.available = true AND b.active = true AND LOWER(b.author) LIKE CONCAT('%', LOWER(:author), '%')")
    List<BookEntity> findBookEntityListByAuthorAndAvailableTrue(@Param("author") String author);

    @Query("SELECT b FROM BookEntity b WHERE b.available = true AND b.active = true AND LOWER(b.title) LIKE CONCAT('%', LOWER(:title), '%')")
    List<BookEntity> findBookEntityListByTitleAndAvailableTrue(@Param("title") String title);

}
