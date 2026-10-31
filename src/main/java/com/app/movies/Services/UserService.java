package com.app.movies.Services;

import com.app.movies.DTO.UserRequest;
import com.app.movies.Models.User;
import com.app.movies.Repositories.UserRepository;
import org.bson.types.ObjectId;
import org.jspecify.annotations.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public Optional<User> getUser(ObjectId id) {
        return userRepository.findById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User createUser(UserRequest userBody) {
        User user = new User();
//      set user fields
        Optional<User> findUser = userRepository.findUserByEmail(userBody.getEmail());
        if (findUser.isPresent()) {
//            throw new Exception("Email already exists");
        }
        return userRepository.insert(user);
    }
}
