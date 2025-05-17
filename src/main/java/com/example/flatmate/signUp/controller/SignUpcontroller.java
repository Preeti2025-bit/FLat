// package com.example.flatmate.signUp.controller;

// import java.util.List;

// import org.springframework.http.ResponseEntity;
// import org.springframework.web.bind.annotation.DeleteMapping;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestBody;
// import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.RestController;

// import com.example.flatmate.ApiResponse;
// import com.example.flatmate.signUp.Model.Signup;
// import com.example.flatmate.signUp.Repository.SignUpService;

// @RestController
// @RequestMapping("/sign_up")
// public class SignUpcontroller {

//     private final SignUpService signUpService;

//     public SignUpcontroller(SignUpService signUpService) {
//         this.signUpService = signUpService;
//     }

//     // @GetMapping
//     // public List<ApiResponse<Signup>> getAllSignUp() {
//     //     return signUpService.getAllSignUp();
//     // }
//     @GetMapping
//     public ResponseEntity<ApiResponse<List<Signup>>> getAllSignUp() {
//         return ResponseEntity.ok(signUpService.getAllSignUp());
//     }
    
//     // @GetMapping("/{id}")
//     // public ResponseEntity<Signup> getSignUpById(@PathVariable String id) {
//     //     return signUpService.getSignUpById(id)
//     //             .map(ResponseEntity::ok)
//     //             .orElse(ResponseEntity.notFound().build());
//     // }
// @GetMapping("/mobile/{mobileNumber}")
// public ResponseEntity<ApiResponse<List<Signup>>>getSignUpByMobile(@PathVariable String mobileNumber) {
//     return ResponseEntity.ok(signUpService.getSignUpByMobile(mobileNumber));

// //     return signUpService.getSignUpByMobile(mobileNumber)
// //             .map(ResponseEntity::ok)
// //             .orElse(ResponseEntity.notFound().build());
//  }
//     @PostMapping
//     public ResponseEntity<ApiResponse<List<Signup>>> createRecord(@RequestBody Signup signup) {
//         return ResponseEntity.ok(signUpService.saveSignUp(signup));

//         // return signUpService.saveSignUp(signup);
//     }

//     @DeleteMapping("/mobile/{mobileNumber}")
//     public ResponseEntity<Void> deleteSignup(@PathVariable String mobileNumber) {
//         signUpService.deleteSignUp(mobileNumber);
//         return ResponseEntity.noContent().build();
//     }
// }
package com.example.flatmate.signUp.controller;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.flatmate.ApiResponse;
import com.example.flatmate.signUp.Model.Signup;
import com.example.flatmate.signUp.Repository.SignUpService;

@RestController
@RequestMapping("/sign_up")
public class SignUpcontroller {

    private final SignUpService signUpService;

    public SignUpcontroller(SignUpService signUpService) {
        this.signUpService = signUpService;
    }

    // Get all signups
    @GetMapping
    public ResponseEntity<ApiResponse<List<Signup>>> getAllSignUp() {
        ApiResponse<List<Signup>> response = signUpService.getAllSignUp();
        HttpStatus status = response.getStatus().equalsIgnoreCase("success") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }

    // Get a signup by mobile number
    @GetMapping("/mobile/{mobileNumber}")
    public ResponseEntity<ApiResponse<List<Signup>>> getSignUpByMobile(@PathVariable String mobileNumber) {
        ApiResponse<List<Signup>> response = signUpService.getSignUpByMobile(mobileNumber);
        HttpStatus status = response.getStatus().equalsIgnoreCase("success") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }

    // Create a new sign-up record
    @PostMapping
    public ResponseEntity<ApiResponse<List<Signup>>> createRecord(@RequestBody Signup signup) {
        ApiResponse<List<Signup>> response = signUpService.saveSignUp(signup);
        HttpStatus status = response.getStatus().equalsIgnoreCase("success") ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(response);
    }

    // Delete a sign-up record by mobile number
    @DeleteMapping("/mobile/{mobileNumber}")
    public ResponseEntity<ApiResponse<Void>> deleteSignup(@PathVariable String mobileNumber) {
        try {
            signUpService.deleteSignUp(mobileNumber);
            ApiResponse<Void> response = new ApiResponse<>("Record deleted", "success", null);
            return ResponseEntity.ok(response);
        } catch (Exception ex) {
            ApiResponse<Void> response = new ApiResponse<>("Failed to delete: " + ex.getMessage(), "error", null);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
    }
}
