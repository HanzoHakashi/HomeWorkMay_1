package edu.attractor.homeworkMay_1.homeworkMay_1.repositories;

import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductRepository extends CrudRepository<Product, Long> {
   Optional<Product> findById(Long id);

    Page<Product> findByNameContainingIgnoreCase(String name, Pageable pageable);


    Page<Product> findByPriceBetween(Double minPrice, Double maxPrice, Pageable pageable);

}
