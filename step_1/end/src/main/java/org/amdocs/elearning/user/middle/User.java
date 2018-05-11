package org.amdocs.elearning.user.middle;


import java.util.Date;

public class User {

    private String firstName;
    private String lastName;
    private String middleInitial;
    private UserType userType;
    private Date dateOfBirth;

    public User(){

    }

    public User(String firstName, String lastName, String middleInitial, UserType userType, Date dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.userType = userType;
        this.dateOfBirth = dateOfBirth;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getMiddleInitial() {
        return middleInitial;
    }

    public UserType getUserType() {
        return userType;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }
}
