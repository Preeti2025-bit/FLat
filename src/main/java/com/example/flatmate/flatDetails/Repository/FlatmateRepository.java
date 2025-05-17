package com.example.flatmate.flatDetails.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.flatmate.flatDetails.Model.Flatmatedetail;

public interface FlatmateRepository extends JpaRepository<Flatmatedetail, Integer>, JpaSpecificationExecutor<Flatmatedetail> {
    // List<Flatmatedetail> findAll();

    // List<Flatmatedetail> findByMobileNumber(Flatmatedetail flatmatedetail);

//     void deleteByMobileNumber(String mobileNumber);
}
    // You can add custom queries later if needed



