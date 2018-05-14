package org.amdocs.elearning.user.middle.user;

import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RestController
public class UserController {

    private final static List<User> users = Arrays.asList(
            new User("1", "Smith", "Joe", "B", UserType.PATRON, LocalDate.parse("1980-01-01")),
            new User("2", "Green", "Anne", "A", UserType.VENUE_OWNER, LocalDate.parse("1983-02-09"))
    );


}
