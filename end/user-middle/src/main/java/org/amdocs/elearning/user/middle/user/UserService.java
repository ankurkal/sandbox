package org.amdocs.elearning.user.middle.user;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class UserService {

    private final static List<User> USERS = Arrays.asList(
            new User("1", "Smith", "Joe", "B", UserType.PATRON, LocalDate.parse("1980-01-01")),
            new User("2", "Green", "Anne", "A", UserType.VENUE_OWNER, LocalDate.parse("1983-02-09"))
    );

    public Optional<User> getUserById(final String id){
        return USERS.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

}
