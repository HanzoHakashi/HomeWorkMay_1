package edu.attractor.homeworkMay_1.homeworkMay_1.controllers;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.ProductDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Product;
import edu.attractor.homeworkMay_1.homeworkMay_1.mappers.ProductMapper;
import edu.attractor.homeworkMay_1.homeworkMay_1.services.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/products")
@AllArgsConstructor
public class ProductController {
    private ProductService productService;
    private ProductMapper productMapper;
    @GetMapping
    public List<ProductDto> getAllProducts() {
        return productService.getAllProducts().stream()
                .map(p->productMapper.fromProduct(p))
                .collect(Collectors.toList());
    }

    @GetMapping("/search")
    public ResponseEntity<Page<ProductDto>> searchProductsByName(@RequestParam("name") String name,
                                                                 @RequestParam(value = "page", defaultValue = "0") int page,
                                                                 @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDto> products = productService.searchProductsByName(name, pageable).map(p->productMapper.fromProduct(p));
        return ResponseEntity.ok(products);
    }

    @GetMapping("/searchByPrice")
    public ResponseEntity<Page<ProductDto>> searchProductsByPriceRange(@RequestParam("minPrice") Double minPrice,
                                                                       @RequestParam("maxPrice") Double maxPrice,
                                                                       @RequestParam(value = "page", defaultValue = "0") int page,
                                                                       @RequestParam(value = "size", defaultValue = "10") int size) {
        Pageable pageable = PageRequest.of(page, size);
        Page<ProductDto> products = productService.searchProductsByPriceRange(minPrice, maxPrice, pageable).map(p->productMapper.fromProduct(p));
        return ResponseEntity.ok(products);
    }


}
