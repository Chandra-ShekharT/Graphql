package com.graphql.services;

import com.graphql.entities.Book;

import java.util.List;

public interface BookService {

    //create
    Book create (Book book);

    //getAll
    List<Book> getAll();

    //get one book
    Book get (int bookId);
}
