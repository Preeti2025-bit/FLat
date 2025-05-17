package com.example.flatmate.flatDetails.controller;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.flatmate.ApiResponse;
import com.example.flatmate.flatDetails.Model.FlatmateFilter;
import com.example.flatmate.flatDetails.Model.Flatmatedetail;
import com.example.flatmate.flatDetails.Repository.FlatmateDetailService;


@RestController
@RequestMapping("/flatmate_detail")
public class FlatmateDetailcontroller {

    private final FlatmateDetailService flatmateDetailService;

    public FlatmateDetailcontroller(FlatmateDetailService flatmateDetailService) {
        this.flatmateDetailService = flatmateDetailService;
    }

    // Get all signups
    @GetMapping
    public ResponseEntity<ApiResponse<List<Flatmatedetail>>> getAllSignUp() {
        ApiResponse<List<Flatmatedetail>> response = flatmateDetailService.getAllSignUp();
        HttpStatus status = response.getStatus().equalsIgnoreCase("success") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }
    // @PostMapping("/filter")
    // public ResponseEntity<List<Flatmatedetail>> getFilteredRecords(@RequestBody FlatmateFilter filter) {
    //     List<Flatmatedetail> filteredRecords = flatmateDetailService.getFilteredRecords(filter);
    //     return ResponseEntity.ok(filteredRecords);
    // }
    @PostMapping("/filter")
    public ResponseEntity<ApiResponse<List<Flatmatedetail>>> getFilteredRecords(@RequestBody FlatmateFilter filter) {
        ApiResponse<List<Flatmatedetail>> response = flatmateDetailService.getFilteredRecords(filter);
        HttpStatus status = response.getStatus().equalsIgnoreCase("success") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(response);
    }
    
//     @GetMapping("/details")
// public ResponseEntity<ApiResponse<List<Flatmatedetail>>> getFilteredRecords(@RequestBody List<Flatmatedetail> filters) {
//     ApiResponse<List<Flatmatedetail>> response = flatmateDetailService.getFilteredRecords(filters);
//     HttpStatus status = response.getStatus().equalsIgnoreCase("success") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
//     return ResponseEntity.status(status).body(response);
// }


    // @GetMapping("/details/{flatmatedetail}")
    // public ResponseEntity<ApiResponse<List<Flatmatedetail>>> getSignUpByMobile(@PathVariable Flatmatedetail flatmatedetail) {
    //     ApiResponse<List<Flatmatedetail>> response = flatmateDetailService.getRecord(flatmatedetail);
    //     HttpStatus status = response.getStatus().equalsIgnoreCase("success") ? HttpStatus.OK : HttpStatus.NOT_FOUND;
    //     return ResponseEntity.status(status).body(response);
    // }

    // Create a new sign-up record
    @PostMapping
    public ResponseEntity<ApiResponse<List<Flatmatedetail>>> createRecord(@RequestBody Flatmatedetail flatmatedetail) {
        ApiResponse<List<Flatmatedetail>> response = flatmateDetailService.saveFlatmate(flatmatedetail);
        HttpStatus status = response.getStatus().equalsIgnoreCase("success") ? HttpStatus.CREATED : HttpStatus.INTERNAL_SERVER_ERROR;
        return ResponseEntity.status(status).body(response);
    }

    // Delete a sign-up record by mobile number
    // @DeleteMapping("/mobile/{mobileNumber}")
    // public ResponseEntity<ApiResponse<Void>> deleteSignup(@PathVariable String mobileNumber) {
    //     try {
    //         flatmateDetailService.deleteSignUp(mobileNumber);
    //         ApiResponse<Void> response = new ApiResponse<>("Record deleted", "success", null);
    //         return ResponseEntity.ok(response);
    //     } catch (Exception ex) {
    //         ApiResponse<Void> response = new ApiResponse<>("Failed to delete: " + ex.getMessage(), "error", null);
    //         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    //     }
    // }
}
