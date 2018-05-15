package org.amdocs.elearning.user.middle.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(final UserService userService){
        this.userService = userService;
    }


    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable final String id){

        final Optional<User> userOptional = this.userService.getUserById(id);

        if(userOptional.isPresent()){
            return new ResponseEntity<User>(userOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(path="/{id}", method=RequestMethod.PUT)
    public ResponseEntity<User> updateUser(@PathVariable final String id, @RequestBody @Valid final User user){


        final User updatedUser = this.userService.updateUser(id, user);
        return new ResponseEntity<User>(updatedUser, HttpStatus.OK);
    }

    @RequestMapping(method=RequestMethod.POST)
    public ResponseEntity<User> createUser(@RequestBody @Valid final User user){

        final User createdUser = this.userService.createUser(user);
        return new ResponseEntity<User>(createdUser, HttpStatus.CREATED);
    }

}
