package com.graphql.controller;

import com.graphql.entities.Book;
import com.graphql.serviceImpl.BookService;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

//@RestController
//@RequestMapping("/books")
@Controller
public class BookController {
    @Autowired
    private BookService bookService;

//    @PostMapping("/add")
    @MutationMapping("createBook")
    public Book create(@Argument BookInput book){
        Book b= new Book();
        b.setTitle(book.getTitle());
        b.setDescription(book.getDescription());
        b.setPrice(book.getPrice());
        b.setAuthor(book.getAuthor());
        b.setNoOfPages(book.getNoOfPages());
        return this.bookService.create(b);
    }

//    @GetMapping("/")
    @QueryMapping("allBooks")
    public List<Book> getAll (){
        return this.bookService.getAll();
    }

//    @GetMapping("/{bookId}")
    @QueryMapping("getBook")
    public  Book getBookById(@Argument int bookId){
        return this.bookService.get(bookId);
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
  class BookInput{
    private String title;
    private String description;
    private String author;
    private Float price;
    private int noOfPages;


  }