package com.example.flatmate.Book.Repository;


// BookService.java

import org.springframework.stereotype.Service;

import com.example.flatmate.Book.Model.Book;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }
    @Transactional
    public Book saveBook(Book book) {
        return bookRepository.save(book);
    }
    // @Transactional
    // public Book createBook(Book book) {
    //     return bookRepository.createBook(book);
    // }

    public void deleteBook(Long id) {
        bookRepository.deleteById(id);
    }
}
