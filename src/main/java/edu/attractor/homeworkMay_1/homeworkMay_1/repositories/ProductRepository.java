package edu.attractor.homeworkMay_1.homeworkMay_1.repositories;

import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
