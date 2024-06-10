package com.library.collection.service;

import com.library.collection.constants.StatusCode;
import com.library.collection.dao.BookDaoService;
import com.library.collection.entities.BookEntity;
import com.library.collection.models.dto.BookDto;
import com.library.collection.models.response.BaseResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class LibraryServiceImpl implements LibraryService {

    private final BookDaoService bookDaoService;

    public LibraryServiceImpl(BookDaoService bookDaoService) {
        this.bookDaoService = bookDaoService;
    }

    @Override
    public BaseResponse addBook(BookDto bookDto) {
        try {
            BookEntity bookEntity = bookDaoService.dtoToEntity(bookDto);

            if (ObjectUtils.isEmpty(bookEntity)) {
                return new BaseResponse(StatusCode.BAD_REQUEST);
            }

            BookEntity savedBook = bookDaoService.save(bookEntity);

            if (ObjectUtils.isEmpty(savedBook)) {
                return new BaseResponse(StatusCode.NO_DATA);
            }

            BookDto response = bookDaoService.entityToDto(savedBook);

            if (ObjectUtils.isEmpty(response)) {
                return new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR);
            }
            return new BaseResponse(response, StatusCode.CREATED);
        } catch (Exception e) {
            log.error("");
            return new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public BaseResponse removeBookByISBN(String ISBN) {
        try {
            BookEntity bookEntity = bookDaoService.getBookEntityByISBN(ISBN);

            if (ObjectUtils.isEmpty(bookEntity)) {
                return new BaseResponse(StatusCode.NO_DATA);
            }
            bookEntity.setActive(false);

            BookEntity savedBook = bookDaoService.save(bookEntity);

            if (ObjectUtils.isEmpty(savedBook)) {
                return new BaseResponse(StatusCode.NO_DATA);
            }

            BookDto response = bookDaoService.entityToDto(savedBook);

            if (ObjectUtils.isEmpty(response)) {
                return new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR);
            }
            return new BaseResponse(response, StatusCode.OK);
        } catch (Exception e) {
            log.error("");
            return new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public BaseResponse getBookByTitle(String title) {
        try {
            List<BookEntity> bookEntityList = bookDaoService.getBookEntitiesByTitle(title);

            if (CollectionUtils.isEmpty(bookEntityList)) {
                return new BaseResponse(StatusCode.NO_DATA);
            }

            List<BookDto> response = bookDaoService.entityToDto(bookEntityList);

            if (CollectionUtils.isEmpty(response)) {
                return new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR);
            }
            return new BaseResponse(response, StatusCode.OK);
        } catch (Exception e) {
            log.error("");
            return new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public BaseResponse getBookByAuthor(String author) {
        try {
            List<BookEntity> bookEntityList = bookDaoService.getBookEntitiesByAuthor(author);

            if (CollectionUtils.isEmpty(bookEntityList)) {
                return new BaseResponse(StatusCode.NO_DATA);
            }

            List<BookDto> response = bookDaoService.entityToDto(bookEntityList);

            if (CollectionUtils.isEmpty(response)) {
                return new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR);
            }
            return new BaseResponse(response, StatusCode.OK);
        } catch (Exception e) {
            log.error("");
            return new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public BaseResponse listAllBooks() {
        try {
            List<BookEntity> bookEntityList = bookDaoService.getAllBookEntities();

            if (CollectionUtils.isEmpty(bookEntityList)) {
                return new BaseResponse(StatusCode.NO_DATA);
            }

            List<BookDto> response = bookDaoService.entityToDto(bookEntityList);

            if (CollectionUtils.isEmpty(response)) {
                return new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR);
            }
            return new BaseResponse(response, StatusCode.OK);
        } catch (Exception e) {
            log.error("");
            return new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR);
        }
    }

    @Override
    public BaseResponse listAvailableBooks() {
        try {
            List<BookEntity> bookEntityList = bookDaoService.getAllAvailableBookEntities();

            if (CollectionUtils.isEmpty(bookEntityList)) {
                return new BaseResponse(StatusCode.NO_DATA);
            }

            List<BookDto> response = bookDaoService.entityToDto(bookEntityList);

            if (CollectionUtils.isEmpty(response)) {
                return new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR);
            }
            return new BaseResponse(response, StatusCode.OK);
        } catch (Exception e) {
            log.error("");
            return new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR);
        }
    }
}
