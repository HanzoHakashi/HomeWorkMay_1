package edu.attractor.homeworkMay_1.homeworkMay_1.services;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.ProductDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Category;
import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Product;
import edu.attractor.homeworkMay_1.homeworkMay_1.mappers.ProductMapper;
import edu.attractor.homeworkMay_1.homeworkMay_1.repositories.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
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
        List<Product> productList = new ArrayList<>();
        productRepository.findAll().forEach(productList::add);
        return productList;
    }
    public Page<Product> searchProductsByName(String name, Pageable pageable) {
        Page<Product> products = productRepository.findByNameContainingIgnoreCase(name, pageable);
        return products;
    }



    public Page<Product> searchProductsByPriceRange(Double minPrice, Double maxPrice, Pageable pageable) {
        Page<Product> products = productRepository.findByPriceBetween(minPrice, maxPrice, pageable);
        return products;
    }



}
