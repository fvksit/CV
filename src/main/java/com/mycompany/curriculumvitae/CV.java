/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.curriculumvitae;

/**
 *
 * @author ASUS
 */
public class CV {
    private String name;
    private String aboutMe;
    private String email;
    private String website;
    private String phoneNumber;
    private String experience;
    private String education;
    private String skills;
    private String certificates;

    // Constructor, Getters, and Setters
    public CV(String name, String aboutMe, String email, String website, String phoneNumber, 
              String experience, String education, String skills, String certificates) {
        this.name = name;
        this.aboutMe = aboutMe;
        this.email = email;
        this.website = website;
        this.phoneNumber = phoneNumber;
        this.experience = experience;
        this.education = education;
        this.skills = skills;
        this.certificates = certificates;
    }

    // Getters
    public String getName() {
        return name;
    }
    
    public String getAboutMe() {
        return aboutMe;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getExperience() {
        return experience;
    }

    public String getEducation() {
        return education;
    }

    public String getSkills() {
        return skills;
    }

    public String getCertificates() {
        return certificates;
    }
}
