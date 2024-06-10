package com.library.collection.dao;

import com.library.collection.entities.BookEntity;
import com.library.collection.mapper.BookMapper;
import com.library.collection.models.dto.BookDto;
import com.library.collection.repositories.BookRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Service class for interacting with the book repository and mapper.
 */
@Service
@Slf4j
public class BookDaoService {

    private final BookRepository bookRepository;
    private final BookMapper bookMapper;

    /**
     * Constructor for BookDaoService.
     *
     * @param bookRepository The repository for accessing book data.
     * @param bookMapper     The mapper for converting between book entities and DTOs.
     */
    public BookDaoService(BookRepository bookRepository, BookMapper bookMapper) {
        this.bookRepository = bookRepository;
        this.bookMapper = bookMapper;
    }

    /**
     * Saves a book entity in the repository.
     *
     * @param bookEntity The book entity to save.
     * @return The saved book entity.
     */
    public BookEntity save(BookEntity bookEntity) {
        try {
            log.info("Saving book entity started");
            return bookRepository.save(bookEntity);
        } catch (Exception e) {
            log.error("Error while saving : {}", e);
            return null;
        }
    }

    /**
     * Retrieves a book entity by its unique ID.
     *
     * @param bookId The unique ID of the book entity to retrieve.
     * @return The book entity corresponding to the given ID.
     */
    public BookEntity getBookEntityByBookId(UUID bookId) {
        try {
            log.info("Fetching book entity by book id : {}", bookId);
            return bookRepository.findBookEntityByBookIdAndActiveTrue(bookId);
        } catch (Exception e) {
            log.error("Error while fetching : {}", e);
            return null;
        }
    }

    /**
     * Retrieves a book entity by its ISBN.
     *
     * @param ISBN The ISBN of the book entity to retrieve.
     * @return The book entity corresponding to the given ISBN.
     */
    public BookEntity getBookEntityByISBN(String ISBN) {
        try {
            log.info("Fetching book entity by ISBN : {}", ISBN);
            return bookRepository.findBookEntityByISBNAndActiveTrue(ISBN);
        } catch (Exception e) {
            log.error("Error while fetching : {}", e);
            return null;
        }
    }

    /**
     * Retrieves a list of book entities by the author's name.
     *
     * @param author The author's name.
     * @return A list of book entities written by the specified author.
     */
    public List<BookEntity> getBookEntitiesByAuthor(String author) {
        try {
            log.info("Fetching book entities by author : {}", author);
            return bookRepository.findBookEntityListByAuthorAndAvailableTrue(author);
        } catch (Exception e) {
            log.error("Error while fetching : {}", e);
            return new ArrayList<>();
        }
    }

    /**
     * Retrieves a list of book entities by the title.
     *
     * @param title The title of the book.
     * @return A list of book entities with the specified title.
     */
    public List<BookEntity> getBookEntitiesByTitle(String title) {
        try {
            log.info("Fetching book entities by title : {}", title);
            return bookRepository.findBookEntityListByTitleAndAvailableTrue(title);
        } catch (Exception e) {
            log.error("Error while fetching : {}", e);
            return new ArrayList<>();
        }
    }

    /**
     * Retrieves all book entities.
     *
     * @return A list of all book entities in the repository.
     */
    public List<BookEntity> getAllBookEntities() {
        try {
            log.info("Fetching all book entities");
            return bookRepository.findBookEntityListByActiveTrue();
        } catch (Exception e) {
            log.error("Error while fetching : {}", e);
            return new ArrayList<>();
        }
    }

    /**
     * Retrieves all available book entities.
     *
     * @return A list of all available book entities in the repository.
     */
    public List<BookEntity> getAllAvailableBookEntities() {
        try {
            log.info("Fetching all available book entities");
            return bookRepository.findBookEntityListByAvailableAndActiveTrue(true);
        } catch (Exception e) {
            log.error("Error while fetching : {}", e);
            return new ArrayList<>();
        }
    }


    /**
     * Converts a list of book entities to a list of book DTOs.
     *
     * @param bookEntities The list of book entities to convert.
     * @return A list of book DTOs.
     */
    public List<BookDto> entityToDto(List<BookEntity> bookEntities) {
        try {
            log.info("Converting book entity to book DTO list");
            return bookMapper.entityToDto(bookEntities);
        } catch (Exception e) {
            log.error("Error while conversion : {}", e);
            return new ArrayList<>();
        }
    }

    /**
     * Converts a book entity to a book DTO.
     *
     * @param bookEntity The book entity to convert.
     * @return The corresponding book DTO.
     */
    public BookDto entityToDto(BookEntity bookEntity) {
        try {
            log.info("Converting book entity to book DTO");
            return bookMapper.entityToDto(bookEntity);
        } catch (Exception e) {
            log.error("Error while conversion : {}", e);
            return new BookDto();
        }
    }

    /**
     * Converts a list of book DTOs to a list of book entities.
     *
     * @param bookDtos The list of book DTOs to convert.
     * @return A list of book entities.
     */
    public List<BookEntity> dtoToEntity(List<BookDto> bookDtos) {
        try {
            log.info("Converting book DTO to book entity list");
            return bookMapper.dtoToEntity(bookDtos);
        } catch (Exception e) {
            log.error("Error while conversion : {}", e);
            return new ArrayList<>();
        }
    }

    /**
     * Converts a book DTO to a book entity.
     *
     * @param bookDto The book DTO to convert.
     * @return The corresponding book entity.
     */
    public BookEntity dtoToEntity(BookDto bookDto) {
        try {
            log.info("Converting book DTO to book entity");
            return bookMapper.dtoToEntity(bookDto);
        } catch (Exception e) {
            log.error("Error while conversion : {}", e);
            return new BookEntity();
        }
    }

}
