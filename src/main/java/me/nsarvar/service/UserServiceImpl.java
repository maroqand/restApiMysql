package me.nsarvar.service;

import me.nsarvar.model.User;
import me.nsarvar.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by nsarvar on 12/27/17.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAll() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(long id) {
        User user = getUserById(id);
        if (user == null){
            throw new RuntimeException("Element not found");
        }
        userRepository.delete(id);
    }

    @Override
    public List<User> findOneByUsername(String username) {
        return userRepository.findOneByUsername(username);
    }


}
