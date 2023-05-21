package edu.attractor.homeworkMay_1.homeworkMay_1.mappers;

import edu.attractor.homeworkMay_1.homeworkMay_1.dtos.ProductDto;
import edu.attractor.homeworkMay_1.homeworkMay_1.entitys.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public static ProductDto fromProduct(Product product){
        return ProductDto.builder()
                .name(product.getName())
                .image(product.getImage())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }

    public static Product fromDto(ProductDto product){
        return Product.builder()
                .name(product.getName())
                .image(product.getImage())
                .description(product.getDescription())
                .price(product.getPrice())
                .build();
    }
}
