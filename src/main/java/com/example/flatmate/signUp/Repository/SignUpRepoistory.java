package com.example.flatmate.signUp.Repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flatmate.Book.Model.Book;
import com.example.flatmate.signUp.Model.Signup;

public interface SignUpRepoistory extends JpaRepository<Signup, String> {

    // You can add custom queries later if needed
}
