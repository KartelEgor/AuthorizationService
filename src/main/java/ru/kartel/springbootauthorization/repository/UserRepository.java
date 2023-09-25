package ru.kartel.springbootauthorization.repository;

import org.springframework.stereotype.Repository;
import ru.kartel.springbootauthorization.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class UserRepository {

    private static Map<User, List<Authorities>> mapOfUsers = new ConcurrentHashMap<>();

    public UserRepository() {
        mapOfUsers.put(new User("Egor", "4357"),
                Arrays.asList(Authorities.DELETE));
        mapOfUsers.put(new User("Oleg", "564"),
                Arrays.asList(Authorities.WRITE));
        mapOfUsers.put(new User("Ira", "345"),
                Arrays.asList(Authorities.READ));
    }

    public List<Authorities> getUserAuthorities(String user, String password) {
        return mapOfUsers.get(new User(user, password));
    }
}