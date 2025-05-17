// package com.example.flatmate.signUp.Repository;

// // BookService.java

// import org.springframework.stereotype.Service;

// import com.example.flatmate.ApiResponse;
// import com.example.flatmate.Book.Model.Book;
// import com.example.flatmate.signUp.Model.Signup;

// import jakarta.transaction.Transactional;

// import java.util.List;
// import java.util.Optional;

// @Service
// public class SignUpService {

//     private final SignUpRepoistory signUpRepoistory;

//     public SignUpService(SignUpRepoistory signUpRepoistory) {
//         this.signUpRepoistory = signUpRepoistory;
//     }

//     public ApiResponse<List<Signup>> getAllSignUp() {
//         List<Signup> all = signUpRepoistory.findAll();
    
//         if (all.isEmpty()) {
//             return new ApiResponse<>("No signups found", "error", null);
//         }
    
//         return new ApiResponse<>("Fetched all signups", "success", all);
//     }
    
//     // public Optional<Signup> getSignUpByMobile(String mobileNumber) {
//     //     return signUpRepoistory.findBymobileNumber(mobileNumber);
//     // }

//     public ApiResponse<List<Signup>> getSignUpByMobile(String mobileNumber) {
//         System.out.println("Searching mobile: [" + mobileNumber + "]");
//         List<Signup> all = signUpRepoistory.findByMobileNumber(mobileNumber.trim());
//         System.out.println("Results found: " + all.size());
            
//         if (all.isEmpty()) {
//             return new ApiResponse<>("No signups found", "error", null);
//         }
    
//         return new ApiResponse<>("Fetched all signups", "success", all);
//     }
    
//     // public Optional<Signup> getSignUpByMobile(String mobileNumber) {
//     //     return signUpRepoistory.findByMobileNumber(mobileNumber);
//     // }
//     @Transactional
//     public void deleteSignUp(String mobileNumber) {
//         signUpRepoistory.deleteByMobileNumber(mobileNumber);
//     }
    
//     // @Transactional
//     // public Signup saveSignUp(Signup signup) {
//     //     return signUpRepoistory.save(signup);
//     // }
        
//     @Transactional
//     public ApiResponse<List<Signup>> saveSignUp(Signup signup) {
//         List<Signup> all = (List<Signup>) signUpRepoistory.save(signup);
//         System.out.println("Results found: " + all.size());
            
//         if (all.isEmpty()) {
//             return new ApiResponse<>("Something went wrong", "error", null);
//         }
    
//         return new ApiResponse<>("Recored added", "success", all);
//     }
    
//     // @Transactional
//     // public Book createBook(Book book) {
//     //     return bookRepository.createBook(book);
//     // }

//     // public void deleteSignUp(String mobileNumber) {
//     //     signUpRepoistory.deleteById(mobileNumber);
//     // }


// }
package com.example.flatmate.signUp.Repository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.flatmate.ApiResponse;
import com.example.flatmate.signUp.Model.Signup;

import java.util.ArrayList;
import java.util.List;

@Service
public class SignUpService {

    private final SignUpRepoistory signUpRepoistory;

    // Constructor Injection
    public SignUpService(SignUpRepoistory signUpRepoistory) {
        this.signUpRepoistory = signUpRepoistory;
    }

    // Get all signups
    public ApiResponse<List<Signup>> getAllSignUp() {
        List<Signup> all = signUpRepoistory.findAll();
        
        if (all.isEmpty()) {
            return new ApiResponse<>("No signups found", "error", null);
        }
        
        return new ApiResponse<>("Fetched all signups", "success", all);
    }

    // Get signups by mobile number
    public ApiResponse<List<Signup>> getSignUpByMobile(String mobileNumber) {
        // Log the incoming mobile number
        // Using a logging framework instead of System.out.println would be more appropriate
        // Example: logger.debug("Searching for mobile: {}", mobileNumber);
        List<Signup> all = signUpRepoistory.findByMobileNumber(mobileNumber.trim());

        if (all.isEmpty()) {
            return new ApiResponse<>("No signups found for the given mobile number", "error", null);
        }
        
        return new ApiResponse<>("Fetched signups by mobile number", "success", all);
    }

    // Delete a signup by mobile number
    @Transactional
    public ApiResponse<Void> deleteSignUp(String mobileNumber) {
        try {
            // Deleting the signup record
            signUpRepoistory.deleteByMobileNumber(mobileNumber);
            return new ApiResponse<>("Signup record deleted successfully", "success", null);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            // Example: logger.error("Error deleting signup: ", e);
            return new ApiResponse<>("Error deleting signup: " + e.getMessage(), "error", null);
        }
    }

    // Save a new signup record
    @Transactional
    public ApiResponse<List<Signup>> saveSignUp(Signup signup) {
        try {
            // Save the signup record
            Signup saved = signUpRepoistory.save(signup);
            
            // Return the saved signup record in a response
            List<Signup> all = new ArrayList<>();
            all.add(saved);

            return new ApiResponse<>("Signup record added successfully", "success", all);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            // Example: logger.error("Error saving signup: ", e);
            return new ApiResponse<>("Error saving signup: " + e.getMessage(), "error", null);
        }
    }
}
