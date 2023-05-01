package com.example.complaintsystem;

public class RegistrationDetails {
        public String fullName;
        public String email;
        public String regNumber;
        public String phoneNumber;
        public String faculty;
        public String department;
        public String password;

        public RegistrationDetails() {
            // Default constructor required for calls to DataSnapshot.getValue(RegistrationDetails.class)
        }

    public RegistrationDetails(String fullName, String email, String regNumber, String phoneNumber, String faculty, String department, String password) {
        this.fullName = fullName;
        this.email = email;
        this.regNumber = regNumber;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.department = department;
        this.password = password;
    }
}
