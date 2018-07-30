package org.amdocs.elearning.user.service.user;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

public class UserDetails {

	@NotNull
	protected String firstName;
	@NotNull
	protected String lastName;
	@NotNull
	protected String middleInitial;
	@NotNull
	protected UserType userType;
	@NotNull
	protected LocalDate dateOfBirth;

	public UserDetails() {
	}

	public UserDetails(@NotNull String firstName, @NotNull String lastName, @NotNull String middleInitial,
			@NotNull UserType userType, @NotNull LocalDate dateOfBirth) {
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

	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}

}