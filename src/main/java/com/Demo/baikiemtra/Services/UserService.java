package com.Demo.baikiemtra.Services;

import com.Demo.baikiemtra.Entities.User;
import com.Demo.baikiemtra.Repositories.UserRepository;
import com.Demo.baikiemtra.RequestEntities.UserCreate;
import com.Demo.baikiemtra.RequestEntities.UserEdit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String id) {
        return userRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Không tìm thấy ID")
        );
    }

    public User createUser(UserCreate userCreate) {
        try {
            User user = new User();
            user.setFirstName(userCreate.getFirstName());
            user.setLastName(userCreate.getLastName());
            user.setEmail(userCreate.getEmail());
            user.setPassword(userCreate.getPassword());

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthday(dateFormat.parse(userCreate.getBirthday()));
            user.setDeleted(false);
            user.setRole(userCreate.getRole());
            userRepository.save(user);
            return user;
        } catch (Exception e) {
            throw new RuntimeException("Error creating user: " + e.getMessage());
        }
    }

    public User updateUser(UserEdit userEdit) {
        try {
            User user = getUserById(userEdit.getId());
            user.setFirstName(userEdit.getFirstName());
            user.setLastName(userEdit.getLastName());
            user.setEmail(userEdit.getEmail());

            DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            user.setBirthday(dateFormat.parse(userEdit.getBirthday()));
            userRepository.save(user);
            return user;
        } catch (Exception e) {
            throw new RuntimeException("Error updating user: " + e.getMessage());
        }
    }

    public User findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public void deleteUser(String id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
        } else {
            throw new RuntimeException("User with ID " + id + " does not exist.");
        }
    }
}