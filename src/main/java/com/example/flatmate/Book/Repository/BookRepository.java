package com.example.flatmate.Book.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flatmate.Book.Model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    // You can add custom queries later if needed
}
