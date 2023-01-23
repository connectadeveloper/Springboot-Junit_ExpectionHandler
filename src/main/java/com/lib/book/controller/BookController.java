package com.lib.book.controller;

import com.lib.book.entity.Book;
import com.lib.book.exception.NoDataAvailable;
import com.lib.book.exception.NoRecordFound;
import com.lib.book.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/lib")
public class BookController {

    @Autowired
    private BookService bookService;

    @GetMapping("/books")
    public ResponseEntity<List<Book>> allBooks() throws NoDataAvailable {
        return new ResponseEntity<>(bookService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/books/{id}")
    public ResponseEntity<Book> oneBookById(@PathVariable int id) throws NoRecordFound {
        return new ResponseEntity<>(bookService.getById(id),HttpStatus.OK);
    }

}
