package org.amdocs.elearning.user.middle.user;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class UserService {

    private final List<User> users = new ArrayList<>();

    public UserService(){
        users.add(new User("00000000-0000-0000-0000-000000000000", "Smith", "Joe", "B", UserType.PATRON, LocalDate.parse("1980-01-01")));
        users.add(new User("11111111-1111-1111-1111-111111111111", "Green", "Anne", "A", UserType.VENUE_OWNER, LocalDate.parse("1983-02-09")));
    }


    public Optional<User> getUserById(final String id){
        return users.stream().filter(user -> user.getId().equals(id)).findFirst();
    }

    public User createUser(final User user){
        //Create user id
        user.setId(UUID.randomUUID().toString());
        //Add user to user list
        users.add(user);
        return user;
    }

    public User updateUser(final String userId, final User user){
        //Set user id before remove/replace
        user.setId(userId);
        users.removeIf(u -> u.getId().equalsIgnoreCase(userId));
        users.add(user);
        return user;
    }

}
