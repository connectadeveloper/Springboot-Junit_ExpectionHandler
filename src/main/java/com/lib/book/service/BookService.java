package com.lib.book.service;

import com.lib.book.entity.Book;
import com.lib.book.exception.NoDataAvailable;
import com.lib.book.exception.NoRecordFound;

import java.util.List;

public interface BookService {

    public List<Book> getAll() throws NoDataAvailable;
    public Book getById(int id) throws NoRecordFound;


}
