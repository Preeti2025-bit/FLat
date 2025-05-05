package com.example.flatmate.signUp.Repository;

// BookService.java

import org.springframework.stereotype.Service;

import com.example.flatmate.Book.Model.Book;
import com.example.flatmate.signUp.Model.Signup;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class SignUpService {

    private final SignUpRepoistory signUpRepoistory;

    public SignUpService(SignUpRepoistory signUpRepoistory) {
        this.signUpRepoistory = signUpRepoistory;
    }

    public List<Signup> getAllSignUp() {
        return signUpRepoistory.findAll();
    }

    // public Optional<Signup> getSignUpByMobile(String mobileNumber) {
    //     return signUpRepoistory.findBymobileNumber(mobileNumber);
    // }
    public Optional<Signup> getSignUpByMobile(String mobileNumber) {
        return signUpRepoistory.findByMobileNumber(mobileNumber);
    }
    
    public void deleteSignUp(String mobileNumber) {
        signUpRepoistory.deleteByMobileNumber(mobileNumber);
    }
    
    @Transactional
    public Signup saveSignUp(Signup signup) {
        return signUpRepoistory.save(signup);
    }
    // @Transactional
    // public Book createBook(Book book) {
    //     return bookRepository.createBook(book);
    // }

    // public void deleteSignUp(String mobileNumber) {
    //     signUpRepoistory.deleteById(mobileNumber);
    // }


}
