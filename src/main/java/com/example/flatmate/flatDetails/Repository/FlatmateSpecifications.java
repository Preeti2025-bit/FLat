package com.example.flatmate.flatDetails.Repository;

import org.springframework.data.jpa.domain.Specification;

import com.example.flatmate.flatDetails.Model.FlatmateFilter;
import com.example.flatmate.flatDetails.Model.Flatmatedetail;

import jakarta.persistence.criteria.Predicate;

public class FlatmateSpecifications {

    public static Specification<Flatmatedetail> filterBy(FlatmateFilter filter) {
        return (root, query, criteriaBuilder) -> {
            Predicate predicate = criteriaBuilder.conjunction();
   
         
            if (filter.getGender() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("gender"), filter.getGender()));
            }
            if (filter.getFlatType() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("flatType"), filter.getFlatType()));
            }
            if (filter.getDrinking() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("drinking"), filter.getDrinking()));
            }
            if (filter.getFlatmateType() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("flatmateType"), filter.getFlatType()));
            }
            if (filter.getEmplyomentType() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("emplyomentType"), filter.getEmplyomentType()));
            } 
            if (filter.getFoodPreference() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("foodPreference"), filter.getFoodPreference()));
            }
           
            if (filter.getFlatmatePreference() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("flatmatePreference"), filter.getFlatmatePreference()));
            }

            if (filter.getSmoking() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("smoking"), filter.getSmoking()));
            } 
            if (filter.getPets() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("pets"), filter.getPets()));
            }
             if (filter.getParkingAvailable() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("parkingAvailable"), filter.getParkingAvailable()));
            } 
            if (filter.getRoomType() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("roomType"), filter.getRoomType()));
            }
            if (filter.getLeaseDuration() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("leaseDuration"), filter.getLeaseDuration()));
            } 
            if (filter.getAgeMin() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("ageMin"), filter.getAgeMin()));
            }
             if (filter.getAgeMax() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("ageMax"), filter.getAgeMax()));
            } 
            if (filter.getGuestPolicy() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("guestPolicy"), filter.getGuestPolicy()));
            }
            if (filter.getPrivacy() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("privacy"), filter.getPrivacy()));
            } 
   

            if (filter.getSocialInteraction() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("socialInteraction"), filter.getSocialInteraction()));
            } 
            if (filter.getCleanliness() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("cleanliness"), filter.getCleanliness()));
            }
             if (filter.getNoiseLevel() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("noiseLevel"), filter.getNoiseLevel()));
            } 
            if (filter.getSharedResponsiblity() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("sharedResponsiblity"), filter.getSharedResponsiblity()));
            }
            
            if (filter.getLookingFor() != null) {
                predicate = criteriaBuilder.and(predicate, criteriaBuilder.equal(root.get("lookingFor"), filter.getLookingFor()));
            }
            // Add other fields similarly

            return predicate;
        };
    }
}
