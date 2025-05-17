package com.example.flatmate.signUp.Repository;


import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.flatmate.Book.Model.Book;
import com.example.flatmate.signUp.Model.Signup;

public interface SignUpRepoistory extends JpaRepository<Signup, Integer> {

    List<Signup> findByMobileNumber(String mobileNumber);

    void deleteByMobileNumber(String mobileNumber);
}
    // You can add custom queries later if needed

