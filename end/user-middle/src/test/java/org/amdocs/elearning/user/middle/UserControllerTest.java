package org.amdocs.elearning.user.middle;

import org.amdocs.elearning.user.middle.user.User;
import org.amdocs.elearning.user.middle.user.UserController;
import org.amdocs.elearning.user.middle.user.UserService;
import org.amdocs.elearning.user.middle.user.UserType;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.http.ResponseEntity;

import java.time.LocalDate;
import java.util.Optional;

public class UserControllerTest {


    UserService userService = Mockito.mock(UserService.class);
    final UserController controller = new UserController(userService);

    @Test
    public void getUserById_Match(){

        Mockito.when(userService.getUserById(Mockito.anyString())).thenReturn(Optional.of(new User("id", "firstName", "lastName", "middleInitial", UserType.PATRON, LocalDate.now())));

        final ResponseEntity<User> responseEntity = this.controller.getUser("id");
        Assert.assertEquals(200, responseEntity.getStatusCodeValue());
        Assert.assertNotNull(responseEntity.getBody());
    }

    @Test
    public void getUserById_NoMatch(){

        Mockito.when(userService.getUserById(Mockito.anyString())).thenReturn(Optional.empty());

        final ResponseEntity<User> responseEntity = this.controller.getUser("id");
        Assert.assertEquals(404, responseEntity.getStatusCodeValue());
        Assert.assertNull(responseEntity.getBody());
    }

    @Test
    public void createUser(){
        final User createRequestUser = new User(null, "test", "test", "t", UserType.PATRON, LocalDate.now());
        final User createdUser = new User("1", "test", "test", "t", UserType.PATRON, LocalDate.now());

        Mockito.when(userService.createUser(Mockito.any())).thenReturn(createdUser);
        final ResponseEntity<User> responseEntity = this.controller.createUser(createRequestUser);

        Assert.assertEquals(201, responseEntity.getStatusCodeValue());
        Assert.assertEquals(createdUser, responseEntity.getBody());
    }
}
