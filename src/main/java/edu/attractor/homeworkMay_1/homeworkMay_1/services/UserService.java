package edu.attractor.homeworkMay_1.homeworkMay_1.services;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.UserDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.User;
import edu.attractor.homeworkMay_1.homeworkMay_1.exeption.UserNotFoundException;
import edu.attractor.homeworkMay_1.homeworkMay_1.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final PasswordEncoder encoder;
    final private UserRepository userRepository;
    public List<User> searchUsersByName(String firstname) {
        return userRepository.findByFirstName(firstname);
    }

    public List<User> searchUsersByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User searchUsersByEmail(String email) {
        User user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UserNotFoundException("User with email " + email + " not found");
        }
        return user;
    }
    public void createUser(UserDto userDto) {
        userRepository.save(User.builder()
                .email(userDto.getEmail())
                .firstName(userDto.getFirstName())
                        .lastName(userDto.getLastName())
                        .address(userDto.getAddress())
                        .username(userDto.getUsername())
                .password(encoder.encode(userDto.getPassword()))
                .build());
    }



    public boolean  existsByEmail(String email){
        return userRepository.existsByEmail(email);
    }
}
