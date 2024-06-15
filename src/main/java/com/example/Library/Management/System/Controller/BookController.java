package com.example.Library.Management.System.Controller;

import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Repository.BookRepo;
import com.example.Library.Management.System.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


import java.util.List;

@RestController
@RequestMapping("books")
public class BookController {


    private BookService bookService;

    public BookController(BookService bookService) {
        this.bookService=bookService;
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return bookService.findAll();
    }

    @GetMapping("{id}")
    public Book getBook(@PathVariable int id) {
        return bookService.findById(id);
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return bookService.save(book);
    }

    @PutMapping("{id}")
    public Book updateBook(@PathVariable int id, @RequestBody Book book) {
        return bookService.save(book);
    }

    @DeleteMapping("{id}")
    public void deleteBook(@PathVariable int id) {
        bookService.deleteById(id);
    }

    @PostMapping("{bookId}/borrow/{userId}")
    public ResponseEntity<Book> borrowBook(@PathVariable int bookId, @PathVariable int userId) {
        Book borrowedBook = bookService.borrowBook(bookId, userId);
        if (borrowedBook != null) {
            return ResponseEntity.ok(borrowedBook);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @PostMapping("/{bookId}/return")
    public ResponseEntity<Book> returnBook(@PathVariable int bookId) {
        Book returnedBook = bookService.returnbook(bookId);
        if (returnedBook != null) {
            return ResponseEntity.ok(returnedBook);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
