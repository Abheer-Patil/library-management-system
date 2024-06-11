package com.library.collection.controller;

import com.library.collection.constants.StatusCode;
import com.library.collection.models.dto.BookDto;
import com.library.collection.models.response.BaseResponse;
import com.library.collection.service.LibraryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController("/api")
@Slf4j
public class LibraryController {

    private final LibraryService libraryService;

    public LibraryController(LibraryService libraryService) {
        this.libraryService = libraryService;
    }

    @Operation(summary = "adding book")
    @PostMapping(path = "/book")
    public ResponseEntity addBook(@RequestBody BookDto request) {
        try {
            if (ObjectUtils.isEmpty(request) || StringUtils.isEmpty(request.getISBN()) || StringUtils.isEmpty(request.getTitle())) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(libraryService.addBook(request));
        } catch (Exception e) {
            log.error("error in adding book, request -> : {}", request);
            log.error("error in adding book : {}", e);
            return ResponseEntity.ok(new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR));
        }
    }


    @Operation(summary = "Removing book by ISBN")
    @DeleteMapping(path = "/book")
    public ResponseEntity removeBook(@RequestParam String ISBN) {
        try {
            if (StringUtils.isEmpty(ISBN)) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(libraryService.removeBookByISBN(ISBN));
        } catch (Exception e) {
            log.error("error in removing book, request -> : {}", ISBN);
            log.error("error in removing book : {}", e);
            return ResponseEntity.ok(new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR));
        }
    }

    @Operation(summary = "fetching books by title")
    @GetMapping(path = "/book/title")
    public ResponseEntity getBooksByTitle(@RequestParam String title) {
        try {
            if (StringUtils.isEmpty(title)) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(libraryService.getBookByTitle(title));
        } catch (Exception e) {
            log.error("error in fetching book, request -> : {}", title);
            log.error("error in fetching book : {}", e);
            return ResponseEntity.ok(new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR));
        }
    }


    @Operation(summary = "fetch books by author")
    @GetMapping(path = "/book/author")
    public ResponseEntity getBooksByAuthor(@RequestParam String author) {
        try {
            if (StringUtils.isEmpty(author)) {
                return ResponseEntity.badRequest().build();
            }
            return ResponseEntity.ok(libraryService.getBookByAuthor(author));
        } catch (Exception e) {
            log.error("error in fetching book, request -> : {}", author);
            log.error("error in fetching book : {}", e);
            return ResponseEntity.ok(new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR));
        }
    }

    @Operation(summary = "fetch all books")
    @GetMapping(path = "/books")
    public ResponseEntity getAllBooks() {
        try {
            return ResponseEntity.ok(libraryService.listAllBooks());
        } catch (Exception e) {
            log.error("error in fetching book : {}", e);
            return ResponseEntity.ok(new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR));
        }
    }

    @Operation(summary = "fetch available books")
    @GetMapping(path = "/books/available")
    public ResponseEntity getAllAvailableBooks() {
        try {
            return ResponseEntity.ok(libraryService.listAvailableBooks());
        } catch (Exception e) {
            log.error("error in fetching book : {}", e);
            return ResponseEntity.ok(new BaseResponse(StatusCode.INTERNAL_SERVER_ERROR));
        }
    }
}
