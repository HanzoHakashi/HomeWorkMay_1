package edu.attractor.homeworkMay_1.homeworkMay_1.repositories;

import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Optional;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAll(Specification spec, Pageable pageable);
}
