package com.example.flatmate.flatDetails.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "flatmate_detail")
public class Flatmatedetail {

    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "gender")
    private String gender;

    @Column(name = "flat_type")
    private String flatType ;

    @Column(name = "flatmate_type")
    private String flatmateType;

    @Column(name = "emp_type")
    private String emplyomentType;
    
    @Column(name = "drinking")
    private String drinking;

    @Column(name = "food_pref")
    private String foodPreference ;

    @Column(name = "flatmate_pref")
    private String flatmatePreference;

    @Column(name = "smoking")
    private String smoking;



    @Column(name = "pets")
    private String pets;

    @Column(name = "parking_aval")
    private String parkingAvailable ;

    @Column(name = "room_type")
    private String roomType;

    @Column(name = "lease_duration")
    private String leaseDuration;
    
    @Column(name = "age_min")
    private String ageMin;

    @Column(name = "age_max")
    private String ageMax ;

    @Column(name = "guest_policy")
    private String guestPolicy;

    @Column(name = "privacy")
    private String Privacy;

    @Column(name = "social_Interact")
    private String socialInteraction;

    @Column(name = "cleanliness")
    private String cleanliness ;

    @Column(name = "noise_level")
    private String noiseLevel;

    @Column(name = "share_repon")
    private String SharedResponsiblity;
    @Column(name = "looking_for")
    private String lookingFor;
    public String getLookingFor() {
        return lookingFor;
    }

    public void setLookingFor(String lookingFor) {
        this.lookingFor = lookingFor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFlatType() {
        return flatType;
    }

    public void setFlatType(String flatType) {
        this.flatType = flatType;
    }

    public String getFlatmateType() {
        return flatmateType;
    }

    public void setFlatmateType(String flatmateType) {
        this.flatmateType = flatmateType;
    }

    public String getEmplyomentType() {
        return emplyomentType;
    }

    public void setEmplyomentType(String emplyomentType) {
        this.emplyomentType = emplyomentType;
    }

    public String getDrinking() {
        return drinking;
    }

    public void setDrinking(String drinking) {
        this.drinking = drinking;
    }

    public String getFoodPreference() {
        return foodPreference;
    }

    public void setFoodPreference(String foodPreference) {
        this.foodPreference = foodPreference;
    }

    public String getFlatmatePreference() {
        return flatmatePreference;
    }

    public void setFlatmatePreference(String flatmatePreference) {
        this.flatmatePreference = flatmatePreference;
    }

    public String getSmoking() {
        return smoking;
    }

    public void setSmoking(String smoking) {
        this.smoking = smoking;
    }

    public String getPets() {
        return pets;
    }

    public void setPets(String pets) {
        this.pets = pets;
    }

    public String getParkingAvailable() {
        return parkingAvailable;
    }

    public void setParkingAvailable(String parkingAvailable) {
        this.parkingAvailable = parkingAvailable;
    }

    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    public String getLeaseDuration() {
        return leaseDuration;
    }

    public void setLeaseDuration(String leaseDuration) {
        this.leaseDuration = leaseDuration;
    }

    public String getAgeMin() {
        return ageMin;
    }

    public void setAgeMin(String ageMin) {
        this.ageMin = ageMin;
    }

    public String getAgeMax() {
        return ageMax;
    }

    public void setAgeMax(String ageMax) {
        this.ageMax = ageMax;
    }

    public String getGuestPolicy() {
        return guestPolicy;
    }

    public void setGuestPolicy(String guestPolicy) {
        this.guestPolicy = guestPolicy;
    }

    public String getPrivacy() {
        return Privacy;
    }

    public void setPrivacy(String privacy) {
        Privacy = privacy;
    }

    public String getSocialInteraction() {
        return socialInteraction;
    }

    public void setSocialInteraction(String socialInteraction) {
        this.socialInteraction = socialInteraction;
    }

    public String getCleanliness() {
        return cleanliness;
    }

    public void setCleanliness(String cleanliness) {
        this.cleanliness = cleanliness;
    }

    public String getNoiseLevel() {
        return noiseLevel;
    }

    public void setNoiseLevel(String noiseLevel) {
        this.noiseLevel = noiseLevel;
    }

    public String getSharedResponsiblity() {
        return SharedResponsiblity;
    }

    public void setSharedResponsiblity(String sharedResponsiblity) {
        SharedResponsiblity = sharedResponsiblity;
    }

    public Flatmatedetail() {
    }

   



 

  
}
