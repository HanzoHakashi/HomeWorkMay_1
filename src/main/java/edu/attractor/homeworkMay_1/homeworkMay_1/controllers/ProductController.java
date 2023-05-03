package edu.attractor.homeworkMay_1.homeworkMay_1.controllers;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.ProductDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Product;
import edu.attractor.homeworkMay_1.homeworkMay_1.mappers.ProductMapper;
import edu.attractor.homeworkMay_1.homeworkMay_1.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    private ProductMapper productMapper;
    @GetMapping("/")
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(p->productMapper.fromProduct(p))
                .collect(Collectors.toList());
    }
}
