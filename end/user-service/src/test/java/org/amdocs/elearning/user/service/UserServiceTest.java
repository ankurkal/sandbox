package org.amdocs.elearning.user.service;

import java.time.LocalDate;
import java.util.Optional;

import org.amdocs.elearning.user.service.user.User;
import org.amdocs.elearning.user.service.user.UserDetails;
import org.amdocs.elearning.user.service.user.UserService;
import org.amdocs.elearning.user.service.user.UserType;
import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {

	final UserService userService = new UserService();

	@Test
	public void getUser_Match() {
		final Optional<User> user = userService.getUserById("0");

		Assert.assertEquals(true, user.isPresent());
	}

	@Test
	public void getUser_NoMatch() {
		final Optional<User> user = userService.getUserById("not a real id");

		Assert.assertEquals(false, user.isPresent());
	}

	@Test
	public void createUser() {
		final UserDetails newUser = new UserDetails("new first", "new last", "M", UserType.PATRON, LocalDate.now());
		final User createdUser = userService.createUser(newUser);
		final Optional<User> retrievedUser = userService.getUserById(createdUser.getId());

		Assert.assertTrue(retrievedUser.isPresent());
		Assert.assertEquals(createdUser, retrievedUser.get());
	}
}
