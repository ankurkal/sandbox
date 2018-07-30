package org.amdocs.elearning.user.service.user;

import java.time.LocalDate;

public class User extends UserDetails {

	private String id;

	public User() {

	}

	public User(final String id, final UserDetails details) {
		this.id = id;
		this.firstName = details.getFirstName();
		this.lastName = details.getLastName();
		this.middleInitial = details.getMiddleInitial();
		this.userType = details.getUserType();
		this.dateOfBirth = details.getDateOfBirth();
	}

	public User(String id, String firstName, String lastName, String middleInitial, UserType userType,
			LocalDate dateOfBirth) {
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
}
