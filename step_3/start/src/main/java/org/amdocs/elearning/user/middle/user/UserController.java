package org.amdocs.elearning.user.middle.user;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final List<User> users = new ArrayList<>();

    public UserController(){
        users.add(new User("1", "Smith", "Joe", "B", UserType.PATRON, LocalDate.parse("1980-01-01")));
        users.add(new User("2", "Green", "Anne", "A", UserType.VENUE_OWNER, LocalDate.parse("1983-02-09")));
    }

    @RequestMapping(path="/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> getUser(@PathVariable final String id){
        final Optional<User> userOptional = users.stream().filter(user -> user.getId().equals(id)).findFirst();
        if(userOptional.isPresent()){
            return new ResponseEntity<User>(userOptional.get(), HttpStatus.OK);
        }

        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
    }

}
