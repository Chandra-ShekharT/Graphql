package com.graphql.serviceImpl;

import com.graphql.entities.Book;
import com.graphql.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService implements com.graphql.services.BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book create(Book book) {

        return this.bookRepository.save(book);
    }

    @Override
    public List<Book> getAll() {
        return this.bookRepository.findAll();
    }

    @Override
    public Book get(int bookId) {
        return this.bookRepository.findById(bookId).orElseThrow(() -> new RuntimeException("Book you are looking for does not exist here"));
    }
}
