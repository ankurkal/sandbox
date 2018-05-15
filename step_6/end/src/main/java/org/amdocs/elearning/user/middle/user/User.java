package org.amdocs.elearning.user.middle.user;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;

public class User {

    private String id;
    @NotNull
    private String firstName;
    @NotNull
    private String lastName;
    @NotNull
    private String middleInitial;
    @NotNull
    private UserType userType;
    @NotNull
    private LocalDate dateOfBirth;

    public User(){

    }

    public User(String id, String firstName, String lastName, String middleInitial, UserType userType, LocalDate dateOfBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleInitial = middleInitial;
        this.userType = userType;
        this.dateOfBirth = dateOfBirth;
    }

    public String getId() {
        return id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setId(final String id){
        this.id = id;
    }
}
