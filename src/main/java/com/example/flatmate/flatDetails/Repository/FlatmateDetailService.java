package com.example.flatmate.flatDetails.Repository;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.flatmate.ApiResponse;
import com.example.flatmate.flatDetails.Model.FlatmateFilter;
import com.example.flatmate.flatDetails.Model.Flatmatedetail;
import com.example.flatmate.signUp.Model.Signup;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlatmateDetailService {

    private final FlatmateRepository flatmateRepository;

    // Constructor Injection
    public FlatmateDetailService(FlatmateRepository flatmateRepository) {
        this.flatmateRepository = flatmateRepository;
    }

    // Get all signups
    public ApiResponse<List<Flatmatedetail>> getAllSignUp() {
        List<Flatmatedetail> all = flatmateRepository.findAll();
        
        if (all.isEmpty()) {
            return new ApiResponse<>("No Record found", "error", null);
        }
        
        return new ApiResponse<>("Fetched all Records", "success", all);
    }


 public ApiResponse<List<Flatmatedetail>> getFilteredRecords(FlatmateFilter filter) {
        Specification<Flatmatedetail> spec = FlatmateSpecifications.filterBy(filter);
        List<Flatmatedetail> all=  flatmateRepository.findAll(spec);
        if (all.isEmpty()) {
            return new ApiResponse<>("No Record found", "error", null);
        }
        
        return new ApiResponse<>("Fetched all Records", "success", all);
    }


    // public ApiResponse<List<Flatmatedetail>> getFilteredRecords(List<Flatmatedetail> filters) {
    //     List<Flatmatedetail> allRecords = flatmateRepository.findAll();
    //     List<Flatmatedetail> filteredRecords = new ArrayList<>();
    
    //     for (Flatmatedetail record : allRecords) {
    //         boolean matches = true;
    
    //         for (Flatmatedetail filter : filters) {
    //             if (filter.getGender() != null && !filter.getGender().equals(record.getGender())) {
    //                 matches = false;
    //                 break;
    //             }
    //             // Apply other filters similarly
    //         }
    
    //         if (matches) {
    //             filteredRecords.add(record);
    //         }
    //     }
    
    //     if (filteredRecords.isEmpty()) {
    //         return new ApiResponse<>("No records found matching the filters", "error", null);
    //     }
    
    //     return new ApiResponse<>("Filtered records fetched successfully", "success", filteredRecords);
    // }
    
    // // Get signups by mobile number
    // public ApiResponse<List<Flatmatedetail>> getRecord(Flatmatedetail flatmatedetail) {
    //     // Log the incoming mobile number
    //     // Using a logging framework instead of System.out.println would be more appropriate
    //     // Example: logger.debug("Searching for mobile: {}", mobileNumber);
    //     List<Flatmatedetail> all = flatmateRepository.findByMobileNumber(flatmatedetail);

    //     if (all.isEmpty()) {
    //         return new ApiResponse<>("No signups found for the given mobile number", "error", null);
    //     }
        
    //     return new ApiResponse<>("Fetched signups by mobile number", "success", all);
    // }

    // Delete a signup by mobile number
    // @Transactional
    // public ApiResponse<Void> deleteSignUp(String mobileNumber) {
    //     try {
    //         // Deleting the signup record
    //         flatmateRepository.deleteByMobileNumber(mobileNumber);
    //         return new ApiResponse<>("Signup record deleted successfully", "success", null);
    //     } catch (Exception e) {
    //         // Log the exception for debugging purposes
    //         // Example: logger.error("Error deleting signup: ", e);
    //         return new ApiResponse<>("Error deleting signup: " + e.getMessage(), "error", null);
    //     }
    // }

    // Save a new signup record
    @Transactional
    public ApiResponse<List<Flatmatedetail>> saveFlatmate(Flatmatedetail flatmatedetail) {
        try {
            // Save the signup record
            Flatmatedetail saved = flatmateRepository.save(flatmatedetail);
            
            // Return the saved signup record in a response
            List<Flatmatedetail> all = new ArrayList<>();
            all.add(saved);

            return new ApiResponse<>("record added successfully", "success", all);
        } catch (Exception e) {
            // Log the exception for debugging purposes
            // Example: logger.error("Error saving signup: ", e);
            return new ApiResponse<>("Error saving Record: " + e.getMessage(), "error", null);
        }
    }
}

