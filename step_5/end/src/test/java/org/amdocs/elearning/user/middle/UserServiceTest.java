package org.amdocs.elearning.user.middle;


import org.amdocs.elearning.user.middle.user.User;
import org.amdocs.elearning.user.middle.user.UserService;
import org.junit.Assert;
import org.junit.Test;

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

}
