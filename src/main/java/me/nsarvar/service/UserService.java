package me.nsarvar.service;

import me.nsarvar.model.User;

import java.util.List;

/**
 * Created by nsarvar on 12/27/17.
 */
public interface UserService {

    List<User> getAll();

    User getUserById(long id);

    User createUser(User user);

    User updateUser(User user);

    void deleteUser(long id);
}
