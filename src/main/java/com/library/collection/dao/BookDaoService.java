package com.library.collection.dao;

import com.library.collection.entities.BookEntity;
import com.library.collection.mapper.BookMapper;
import com.library.collection.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@Slf4j
public class BookDaoService {

    private final BookRepository bookRepository;

    private final BookMapper bookMapper;

    public BookDaoService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    public BookEntity save(BookEntity bookEntity) {
        try {
            return bookRepository.save(bookEntity);
        } catch (Exception e) {
            log.error("error while saving : {}", e);
            return null;
        }
    }

    public BookEntity getBookEntityByBookId(UUID bookId) {
        try {
            return bookRepository.findBookEntityByBookIdAndActiveTrue(bookId);
        } catch (Exception e) {
            log.error("error while fetching : {}", e);
            return null;
        }
    }


    public List<BookEntity> getBookEntitiesByAuthor(String author) {
        try {
            return bookRepository.findBookEntityListByAuthorAndAvailableTrue(author);
        } catch (Exception e) {
            log.error("error while fetching : {}", e);
            return new ArrayList<>();
        }
    }

    public List<BookEntity> getBookEntitiesByTitle(String title) {
        try {
            return bookRepository.findBookEntityListByTitleAndAvailableTrue(title);
        } catch (Exception e) {
            log.error("error while fetching : {}", e);
            return new ArrayList<>();
        }
    }

    public List<BookEntity> getAllBookEntities() {
        try {
            return bookRepository.findBookEntityListByActiveTrue();
        } catch (Exception e) {
            log.error("error while fetching : {}", e);
            return new ArrayList<>();
        }
    }

    public List<BookEntity> getAllAvailableBookEntities() {
        try {
            return bookRepository.findBookEntityListByAvailableAndActiveTrue(true);
        } catch (Exception e) {
            log.error("error while fetching : {}", e);
            return new ArrayList<>();
        }
    }

}
