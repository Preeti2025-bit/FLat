package com.example.flatmate.signUp.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.flatmate.Book.Model.Book;
import com.example.flatmate.signUp.Model.Signup;
import com.example.flatmate.signUp.Repository.SignUpService;

@RestController
@RequestMapping("/sign_up")
public class SignUpcontroller {

    private final SignUpService signUpService;

    public SignUpcontroller(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    @GetMapping
    public List<Signup> getAllSignUp() {
        return signUpService.getAllSignUp();
    }

    // @GetMapping("/{id}")
    // public ResponseEntity<Signup> getSignUpById(@PathVariable String id) {
    //     return signUpService.getSignUpById(id)
    //             .map(ResponseEntity::ok)
    //             .orElse(ResponseEntity.notFound().build());
    // }
@GetMapping("/mobile/{mobileNumber}")
public ResponseEntity<Signup> getSignUpByMobile(@PathVariable String mobileNumber) {
    return signUpService.getSignUpByMobile(mobileNumber)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
}
    @PostMapping
    public Signup createBook(@RequestBody Signup signup) {
        return signUpService.saveSignUp(signup);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSignup(@PathVariable String id) {
        signUpService.deleteSignUp(id);
        return ResponseEntity.noContent().build();
    }
}
