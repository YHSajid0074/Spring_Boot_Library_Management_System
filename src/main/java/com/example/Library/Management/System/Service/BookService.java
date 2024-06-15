package com.example.Library.Management.System.Service;

import com.example.Library.Management.System.Entity.Book;
import com.example.Library.Management.System.Entity.User;
import com.example.Library.Management.System.Repository.BookRepo;
import com.example.Library.Management.System.Repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    private final BookRepo bookRepo;
    private final UserRepo userRepo;

    public BookService(BookRepo bookRepo, UserRepo userRepo) {
        this.bookRepo = bookRepo;
        this.userRepo = userRepo;
    }

    public List<Book> findAll() {
        return bookRepo.findAll();
    }

    public Book findById(int id) {
        return bookRepo.findById(id).orElse(null);
    }

    public Book save(Book book) {
        return bookRepo.save(book);
    }

    public void deleteById(int id) {
        bookRepo.deleteById(id);
    }

    public Book borrowBook(int bookId, int userId) {
        Book book = findById(bookId);
        User user = userRepo.findById(userId).orElse(null);
        if (book != null && !book.isBorrowed() && user != null) {
            book.setBorrowed(true);
            return bookRepo.save(book);
        }
        return null;
    }
    public Book returnbook(int bookId){
Book book = findById(bookId);
if(book != null && book.isBorrowed()){
    book.setBorrowedBy(null);
    book.setBorrowed(false);
    return save(book);
}
return null;

    }

}

