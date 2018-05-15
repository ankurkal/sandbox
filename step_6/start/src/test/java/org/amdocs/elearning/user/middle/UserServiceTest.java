package org.amdocs.elearning.user.middle;


import org.amdocs.elearning.user.middle.user.User;
import org.amdocs.elearning.user.middle.user.UserService;
import org.amdocs.elearning.user.middle.user.UserType;
import org.junit.Assert;
import org.junit.Test;

import java.time.LocalDate;
import java.util.Optional;

public class UserServiceTest {


    final UserService userService = new UserService();

    @Test
    public void testGetUser_Match(){
        final Optional<User> user = userService.getUserById("00000000-0000-0000-0000-000000000000");

        Assert.assertEquals(true, user.isPresent());
    }

    @Test
    public void testGetUser_NoMatch(){
        final Optional<User> user = userService.getUserById("not a real id");

        Assert.assertEquals(false, user.isPresent());
    }

    @Test
    public void testCreateUser(){
        final User newUser = new User(null, "new first", "new last", "M", UserType.PATRON, LocalDate.now());
        final User createdUser = userService.createUser(newUser);
        final Optional<User> retrievedUser = userService.getUserById(createdUser.getId());

        Assert.assertTrue(retrievedUser.isPresent());
        Assert.assertEquals(createdUser, retrievedUser.get());
    }
}
