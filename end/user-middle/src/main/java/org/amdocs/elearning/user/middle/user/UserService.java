package org.amdocs.elearning.user.middle.user;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserService {

	private final List<User> users = new ArrayList<>();

	public UserService() {
		users.add(new User("0", "Smith", "Joe", "B", UserType.PATRON, LocalDate.parse("1980-01-01")));
		users.add(new User("1", "Green", "Anne", "A", UserType.VENUE_OWNER, LocalDate.parse("1983-02-09")));
	}

	public Optional<User> getUserById(final String id) {
		return users.stream().filter(user -> user.getId().equals(id)).findFirst();
	}

	public User createUser(final UserDetails userDetails) {
		final int newUserId = users.size();
		final User newUser = new User(String.valueOf(newUserId), userDetails);
		users.add(newUser);
		return newUser;
	}

	public List<User> getAllUsers() {
		return users;
	}
}
