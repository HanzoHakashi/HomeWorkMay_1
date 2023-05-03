package edu.attractor.homeworkMay_1.homeworkMay_1.services;

import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Product;
import edu.attractor.homeworkMay_1.homeworkMay_1.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
    final private ProductRepository productRepository;

    public Product saveProduct(String name, String image, Integer quantity,String description,Double price){
        Product product = Product.builder()
                .name(name)
                .image(image)
                .quantity(quantity)
                .description(description)
                .price(price)
                .build();
        return product;
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
