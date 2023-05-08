package edu.attractor.homeworkMay_1.homeworkMay_1.repositories;

import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
