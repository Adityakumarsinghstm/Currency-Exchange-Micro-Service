package com.socialMediaApp.dao;

import com.socialMediaApp.entity.User;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static final List<User> users = new ArrayList<>();
    private static int countUser = 0;
    static {
        users.add(new User(++countUser,"Rohit", LocalDate.now().minusYears(25)));
        users.add(new User(++countUser,"Shefali", LocalDate.now().minusYears(21)));
        users.add(new User(++countUser,"KumKum",LocalDate.now().minusYears(22)));
    }

    public List<User> findAll()
    {
        return users;
    }

    public User findOne(int userId)
    {
        Predicate<? super User> predicate = user -> user.getId().equals(userId);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public User save(User user)
    {
        user.setId(++countUser);
        users.add(user);
        return user;

    }

    public void deleteById(int userId)
    {
        Predicate<? super User> predicate = user -> user.getId().equals(userId);
        users.removeIf(predicate);
    }
}
