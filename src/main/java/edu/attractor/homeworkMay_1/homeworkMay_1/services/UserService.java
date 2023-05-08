package edu.attractor.homeworkMay_1.homeworkMay_1.services;

import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.User;
import edu.attractor.homeworkMay_1.homeworkMay_1.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    final private UserRepository userRepository;
    public List<User> searchUsersByName(String firstname) {
        return userRepository.findByFirstName(firstname);
    }

    public List<User> searchUsersByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public List<User> searchUsersByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
