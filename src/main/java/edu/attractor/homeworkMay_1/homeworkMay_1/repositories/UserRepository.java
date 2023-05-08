package edu.attractor.homeworkMay_1.homeworkMay_1.repositories;

import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findByFirstName(String firstname);


    List<User> findByEmail(String email);

    List<User> findByUsername(String username);
}
