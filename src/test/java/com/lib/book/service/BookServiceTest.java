package com.lib.book.service;

import com.lib.book.entity.Book;
import com.lib.book.repository.BookRepo;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class BookServiceTest {

    @MockBean
    private BookRepo bookRepo;

    @InjectMocks
    private BookServiceImpl bookService;

    List<Book> books;
    Book book1;
    Book book2;
    Book book3;

    @BeforeAll
    private void setup(){

         book1 = new Book(101, "Book No 1", 3);
         book2 = new Book(102, "Book No 2", 4);
         book3 = new Book(103, "Book No 3", 5);
         books = Arrays.asList(book1, book2, book3);
    }

    @BeforeEach
    private void before(){
        Mockito.when(bookRepo.findAll()).thenReturn(books);
        Mockito.when(bookRepo.findById(book1.getBookId())).thenReturn(Optional.ofNullable(book1));
    }

}
