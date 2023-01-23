package com.lib.book.service;

import com.lib.book.entity.Book;
import com.lib.book.exception.NoDataAvailable;
import com.lib.book.exception.NoRecordFound;
import com.lib.book.repository.BookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static com.lib.book.enums.ErrorEnum.NoDataAvailable_Error;
import static com.lib.book.enums.ErrorEnum.NoRecordFound_Error;

@Service
@Transactional
public class BookServiceImpl implements BookService{

    @Autowired
    private BookRepo bookRepo;

    @Override
    public List<Book> getAll() throws NoDataAvailable{

        Optional<List<Book>> books = Optional.of(bookRepo.findAll());
        if(!books.isPresent())
            throw new NoDataAvailable(NoDataAvailable_Error.getCode(), NoDataAvailable_Error.getMsg());
        return books.get();
    }

    @Override
    public Book getById(int id) throws NoRecordFound{
        Optional<Book> book = bookRepo.findById(id);
        if(!book.isPresent())
            throw new NoRecordFound(NoRecordFound_Error.getCode(), NoRecordFound_Error.getMsg());
        
        return book.get();
    }
}
